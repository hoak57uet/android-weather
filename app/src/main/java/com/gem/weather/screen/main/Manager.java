package com.gem.weather.screen.main;

import android.content.Context;

import com.gem.weather.rest.dto.WeatherCountryDTO;

/**
 * Created by HoaPham on 5/3/18.
 */

public interface Manager {
  public interface MainView {

    Context getContext();

    void getWeatherDataSuccess(WeatherCountryDTO data);
  }

  public interface MainPresenter {

    void getWeatherData();
  }
}
