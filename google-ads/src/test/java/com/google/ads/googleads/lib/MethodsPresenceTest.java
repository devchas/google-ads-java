// Copyright 2020 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.ads.googleads.lib;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import static junit.framework.TestCase.assertTrue;

@RunWith(JUnit4.class)
public class MethodsPresenceTest {
  /**
   * Verifies that the list of all service client methods in a given GoogleAdsVersion class matches
   * that provided in the testdata/avail_service_clients.txt file.
   *
   * <p>The avail_service_clients.txt file should be the standard against which all releases are
   * compared. In the event the list of services changes in the API, this test will fail. Then,
   * avail_service_clients.txt should be updated so that this test passes.
   */
  @Test
  public void methodsListMatches() throws ClassNotFoundException, NoSuchMethodException {
    // Gets the fully qualified return type of the GoogleAdsAllVersions getLatestVersion method,
    // which is the class from which the methods will be retrieved.
    Method latestVersionMethod = GoogleAdsAllVersions.class.getMethod("getLatestVersion");
    Class cls = Class.forName(latestVersionMethod.getReturnType().getName());

    // Retrieves a list of the methods in the GoogleAdsVersion class using reflection and adds
    // each to a set.
    List<Method> methods = Arrays.asList(cls.getDeclaredMethods());
    Set<String> serviceListReflection = new HashSet<>();
    for (Method method : methods) {
      serviceListReflection.add(method.toString());
    }

    // Retrieves the list of service client methods in the provided avail_service_clients.txt file.
    InputStream inputStream =
        MethodsPresenceTest.class.getResourceAsStream("/testdata/avail_service_clients.txt");
    Scanner scanner = new Scanner(inputStream);
    Set<String> serviceListResource = new HashSet<>();
    while (scanner.hasNext()) {
      serviceListResource.add(scanner.nextLine());
    }
    serviceListResource.remove("");

    assertTrue(
        serviceListReflection.size() == serviceListResource.size()
            && serviceListReflection.containsAll(serviceListResource));
  }
}
