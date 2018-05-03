package com.gem.weather.screen.main.listweather;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

/**
 * Created by HoaPham on 5/3/18.
 */

public interface Manager {
  public interface WeatherPresenter {

    WeatherModel getModel();

    void getWeatherData();
  }

  public interface WeatherView {

    Context getActivityContext();

    void dismissLoading();

    void loading();
  }
}
