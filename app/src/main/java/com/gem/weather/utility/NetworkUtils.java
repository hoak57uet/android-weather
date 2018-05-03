package com.gem.weather.utility;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.gem.weather.App;

/**
 * Created by HoaPham on 5/4/18.
 */

public class NetworkUtils {
  public static boolean isNetworkAvailable() {
    ConnectivityManager connectivityManager
        = (ConnectivityManager) App.getInstance().getSystemService(Context.CONNECTIVITY_SERVICE);
    NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
    return activeNetworkInfo != null && activeNetworkInfo.isConnected();
  }
}
