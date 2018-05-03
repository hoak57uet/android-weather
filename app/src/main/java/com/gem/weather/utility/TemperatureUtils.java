package com.gem.weather.utility;

/**
 * Created by HoaPham on 5/3/18.
 */

public class TemperatureUtils {
  public static Double KtoCencious(Double k) {
    return k - 273;
  }

  public static String toString(Double temperature) {
    return temperature == null ? "" : temperature.intValue() + "";
  }
}
