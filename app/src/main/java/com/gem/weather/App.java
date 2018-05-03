package com.gem.weather;

import android.app.Application;

import com.crashlytics.android.Crashlytics;

import io.fabric.sdk.android.Fabric;
import io.realm.Realm;

/**
 * Created by HoaPham on 5/4/18.
 */

public class App extends Application {
  private static App app;

  @Override
  public void onCreate() {
    super.onCreate();
    Realm.init(this);
    Fabric.with(this, new Crashlytics());
    app = this;
  }

  public static App getInstance() {
    return app;
  }
}
