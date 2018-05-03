package com.gem.weather.utility;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by HoaPham on 5/4/18.
 */

public class RealmUtils {
  public static RealmConfiguration getConfig() {
    return new RealmConfiguration.Builder()
        .schemaVersion(1)
        .build();
  }

  public static Realm getInstance() {
    return Realm.getInstance(getConfig());
  }
}
