// Copyright 2018 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     https://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.ads.googleads.lib.utils;

import com.google.ads.googleads.test.Resource;
import com.google.ads.googleads.test.TestCase;
import com.google.ads.googleads.test.TestSuite;
import com.google.ads.googleads.v1.common.ExpandedTextAdInfo;
import com.google.ads.googleads.v1.resources.Ad;
import com.google.ads.googleads.v1.resources.AdGroupAd;
import com.google.common.base.Charsets;
import com.google.common.truth.Truth;
import com.google.protobuf.FieldMask;
import com.google.protobuf.StringValue;
import com.google.protobuf.TextFormat;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import static org.junit.Assert.assertEquals;

/**
 * Tests the {@link FieldMasks} utility.
 */
@RunWith(Parameterized.class)
public class FieldMasksTest {
  @Parameters(name = "{index}: {0}")
  public static Collection<Object[]> data() throws IOException {
    InputStream stream = FieldMasksTest.class.getResourceAsStream("/testdata/test_cases.textproto");
    Readable readable = new InputStreamReader(stream, Charsets.UTF_8);

    TestSuite.Builder builder = TestSuite.newBuilder();
    TextFormat.merge(readable, builder);
    TestSuite testSuite = builder.build();

    List<Object[]> result = new ArrayList<>();
    for (TestCase testCase : testSuite.getTestCasesList()) {
      result.add(new Object[] {testCase.getDescription(), testCase});
    }
    return result;
  }

  private final TestCase testCase;

  public FieldMasksTest(String description, TestCase testCase) {
    this.testCase = testCase;
  }

  @Test
  public void testFieldMaskCompare() {
    FieldMask actual =
        FieldMasks.compare(testCase.getOriginalResource(), testCase.getModifiedResource());
    Truth.assertThat(testCase.getExpectedMask()).isEqualTo(actual);
  }

  @Test
  public void testFieldMaskAllSetFieldsOf() {
    Resource resource = testCase.getModifiedResource();
    FieldMask actual = FieldMasks.allSetFieldsOf(resource);
    FieldMask expected = FieldMasks.compare(resource.getDefaultInstanceForType(), resource);
    Truth.assertThat(expected).isEqualTo(actual);
  }

  @Test
  public void testFieldMaskOfNestedResource() {
    Ad ad = Ad.newBuilder()
      .setName(StringValue.of("Test Name"))
      .setExpandedTextAd(ExpandedTextAdInfo.newBuilder()
        .setDescription(StringValue.of("Test Description"))
        .build())
      .addFinalUrls(StringValue.of("http://www.example.com/cruise/space/"))
      .build();

    AdGroupAd adGroupAd = AdGroupAd.newBuilder()
      .setResourceName("Resource Name")
      .setAd(ad)
      .build();

    FieldMask actual = FieldMasks.allSetFieldsOf(adGroupAd);
    assertEquals(4, actual.getPathsCount());
  }
}
