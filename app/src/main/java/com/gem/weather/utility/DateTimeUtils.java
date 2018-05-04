package com.gem.weather.utility;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by HoaPham on 5/3/18.
 */

public class DateTimeUtils {
  public static String showNow() {
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    return formatter.format(new Date());
  }
}
