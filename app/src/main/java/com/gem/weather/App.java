package com.gem.weather;

import android.app.Application;

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
    app = this;
  }

  public static App getInstance() {
    return app;
  }
}
