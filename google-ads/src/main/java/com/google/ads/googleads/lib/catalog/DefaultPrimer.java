package com.google.ads.googleads.lib.catalog;

import com.google.ads.googleads.lib.GoogleAdsAllVersions;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.rpc.TransportChannel;
import com.google.auth.Credentials;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicBoolean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DefaultPrimer extends Primer {

  private static final Logger logger = LoggerFactory.getLogger(DefaultPrimer.class);
  private static final int MAX_NUM_THREADS = 10;
  private final ExecutorService executorService =
      // Executors.newFixedThreadPool(MAX_NUM_THREADS, new PrimerThreadFactory());
      Executors.newWorkStealingPool(MAX_NUM_THREADS);
  private final ConcurrentHashMap<Class<?>, Boolean> PRIMED_SERVICES = new ConcurrentHashMap();
  private final AtomicBoolean GRPC_PRIMED = new AtomicBoolean(false);
  private final AtomicBoolean PROTOBUF_PRIMED = new AtomicBoolean(false);

  DefaultPrimer() {}

  private void runAndPreserveStacktrace(Runnable runnable) {
    executorService.submit(new StackTracePreservingRunnable(runnable));
  }

  @Override
  public void primeCredentialsAsync(Credentials credentials) {
    runAndPreserveStacktrace(
        () -> {
          logger.info("Priming creds");
          try {
            credentials.getRequestMetadata();
          } catch (IOException e) {
            throw new RuntimeException(e);
          }
          logger.info("Finished priming creds");
        });
  }

  @Override
  public void primeForServiceClientAsync(Class<?> serviceClass) {
    PRIMED_SERVICES.computeIfAbsent(
        serviceClass,
        (clazz) -> {
          runAndPreserveStacktrace(() -> primeForServiceClient(clazz));
          return true;
        });
  }

  private void primeForServiceClient(Class<?> serviceClass) {
    logger.info("Priming GoogleAdsRow");
    String canonicalName = serviceClass.getCanonicalName();
    String rowClassName =
        canonicalName.substring(0, canonicalName.lastIndexOf(".")) + ".GoogleAdsRow";
    try {
      Class.forName(rowClassName);
    } catch (ClassNotFoundException e) {
      logger.info("Failed to prime " + rowClassName, e);
    }
    String feedItemName = canonicalName.replaceFirst("services\\..*", "resources.FeedItem");
    try {
      Class.forName(feedItemName);
    } catch (ClassNotFoundException e) {
      logger.info("Failed to prime " + feedItemName, e);
    }
    logger.info("Finished priming GoogleAdsRow");
  }

  @Override
  public void primeGrpcAsync() {
    boolean isPrimed = GRPC_PRIMED.compareAndSet(true, true);
    if (!isPrimed) {
      primeClassNamesResourceAsync("/primer/grpc_class_names");
    }
  }

  @Override
  public void primeProtobufAsync() {
    boolean isPrimed = PROTOBUF_PRIMED.compareAndSet(true, true);
    if (!isPrimed) {
      primeClassNamesResourceAsync("/primer/protobuf_class_names");
      // primeManagedChannelBuilderAsync("googleads.googleapis.com", 443);
    }
  }

  private void primeManagedChannelBuilderAsync(String host, int port) {
    runAndPreserveStacktrace(
        () -> {
          try (TransportChannel channel =
              InstantiatingGrpcChannelProvider.newBuilder()
                  .setEndpoint("google.com:443")
                  .build()
                  .withExecutor(Executors.newScheduledThreadPool(1))
                  .withHeaders(Collections.emptyMap())
                  .getTransportChannel()) {
            channel.shutdownNow();
          } catch (Exception e) {
            throw new RuntimeException(e);
          }
        });
  }

  @Override
  public void primeTransportChannelAsync(String endpoint) {}

  @Override
  public void primeAllVersionsAsync() {
    runAndPreserveStacktrace(() -> GoogleAdsAllVersions.class.getMethods());
  }

  private void primeClassNamesResourceAsync(String resourcePath) {
    runAndPreserveStacktrace(() -> primeClassNamesResource(resourcePath));
  }

  private void primeClassNamesResource(String resourcePath) {
    logger.info("Priming resource path: " + resourcePath);
    // Read into memory first to avoid waiting for IO.
    List<String> classNamesToLoad = new ArrayList();
    try (BufferedReader in =
        new BufferedReader(
            new InputStreamReader(DefaultPrimer.class.getResourceAsStream(resourcePath)))) {
      String line;
      while ((line = in.readLine()) != null) {
        classNamesToLoad.add(line);
        String finalLine = line;
        StackTracePreservingRunnable runnable =
            new StackTracePreservingRunnable(
                () -> {
                  try {
                    Class.forName(finalLine);
                  } catch (ClassNotFoundException e) {
                    // e.printStackTrace();
                  }
                });
        runnable.run();
        // executorService.submit(runnable);
      }
    } catch (IOException e) {
      logger.info("Failed to prime", e);
    }

    // if (true) return;
    // Collections.shuffle(classNamesToLoad);
    //
    // AtomicInteger counter = new AtomicInteger(0);
    // Map<Integer, List<String>> workChunks =
    //     classNamesToLoad.stream()
    //         .collect(Collectors.groupingBy(c -> counter.incrementAndGet() / MAX_NUM_THREADS));
    // workChunks
    //     .values()
    //     .forEach(
    //         chunk ->
    //             executorService.submit(
    //                 new StackTracePreservingRunnable(
    //                     () -> {
    //                       for (String toLoad : chunk) {
    //                         try {
    //                           Class.forName(toLoad);
    //                         } catch (ClassNotFoundException e) {
    //                           logger.info("Failed to prime", e);
    //                         }
    //                       }
    //                     })));

    logger.info("Finished priming resource path: " + resourcePath);
  }

  public void primeLogging() {
    // executorService.submit(()->{
    //   LoggerFactory.getLogger()
    // })
  }

  private static class StackTracePreservingRunnable implements Runnable {

    private final StackTraceElement[] originalStackTrace = Thread.currentThread().getStackTrace();
    private final Runnable innerRunnable;

    public StackTracePreservingRunnable(Runnable innerRunnable) {
      this.innerRunnable = innerRunnable;
    }

    @Override
    public void run() {
      try {
        innerRunnable.run();
      } catch (Exception cause) {
        CrossThreadException exception = new CrossThreadException(originalStackTrace, cause);
        exception.printStackTrace(); // TODO remove/replace with logging.
        throw exception;
      }
    }

    private static class CrossThreadException extends RuntimeException {

      public CrossThreadException(StackTraceElement[] originalStackTrace, Exception cause) {
        super(cause);
        setStackTrace(originalStackTrace);
      }
    }
  }

  private static class PrimerThreadFactory implements ThreadFactory {

    private volatile int threadIdx = 0;

    @Override
    public Thread newThread(Runnable r) {
      return new Thread(r) {
        {
          setName("Primer thread " + threadIdx++);
          setDaemon(true);
        }
      };
    }
  }
}
