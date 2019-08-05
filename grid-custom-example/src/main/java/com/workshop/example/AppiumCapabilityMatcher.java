package com.workshop.example;

import org.openqa.grid.internal.utils.DefaultCapabilityMatcher;

import java.util.Map;

@SuppressWarnings("unused")
public class AppiumCapabilityMatcher extends DefaultCapabilityMatcher {

  @Override
  public boolean matches(Map<String, Object> providedCapabilities, Map<String, Object> requestedCapabilities) {
    /*
      Basic match -> Browser name, browser version, and platform match
     */
    boolean basicMatch = super.matches(providedCapabilities, requestedCapabilities);

    /*
      Other things to match: platformVersion, deviceName
     */
    boolean matchesPlatformVersion = true;
    if (requestedCapabilities.containsKey("platformVersion")) {
      matchesPlatformVersion = providedCapabilities.get("platformVersion").toString()
              .equalsIgnoreCase(requestedCapabilities.get("platformVersion").toString());
    }
    boolean matchesDeviceName = true;
    if (requestedCapabilities.containsKey("deviceName")) {
      matchesDeviceName = providedCapabilities.get("deviceName").toString()
              .equalsIgnoreCase(requestedCapabilities.get("deviceName").toString());
    }
    return basicMatch && matchesPlatformVersion && matchesDeviceName;
  }

}
