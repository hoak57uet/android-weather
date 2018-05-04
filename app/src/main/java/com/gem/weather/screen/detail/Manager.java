package com.gem.weather.screen.detail;

import android.support.v7.app.AppCompatActivity;

import com.gem.weather.rest.dto.WeatherCountryDTO;

/**
 * Created by HoaPham on 5/3/18.
 */

public interface Manager {
  public interface WeatherDetailPresenter {

    void getDetailWeather();
  }

  public interface WeatherDetailView {

    AppCompatActivity getContextActivity();

    void updateDetailView(DetailModel model);
  }
}
