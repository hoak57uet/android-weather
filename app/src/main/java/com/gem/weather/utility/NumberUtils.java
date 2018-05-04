package com.gem.weather.utility;

/**
 * Created by HoaPham on 5/4/18.
 */

public class NumberUtils {
  public static String formatPercent(Double number) {
    return String.valueOf(number) + "%";
  }

  public static String getWindSpeed(Double speed) {
    return String.valueOf(speed) + "mph W";
  }

  public static String getPressure(Double pressure) {
    return String.valueOf(pressure) + "";
  }
}
