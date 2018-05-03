package com.gem.weather.screen.splash;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.gem.weather.R;
import com.gem.weather.screen.main.MainActivity;

public class SplashActivity extends AppCompatActivity {
  private static final String FLAVOR_DEV = "dev";
  private static final long DELAY_TIME_SPLASH = 2000;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_splash);
    throw new RuntimeException("Test fabric");
//    Handler handler = new Handler();
//    handler.postDelayed(new Runnable() {
//      @Override
//      public void run() {
//        SplashActivity.this.startActivity(new Intent(SplashActivity.this, MainActivity.class));
//        SplashActivity.this.finish();
//      }
//    }, DELAY_TIME_SPLASH);
  }
}
