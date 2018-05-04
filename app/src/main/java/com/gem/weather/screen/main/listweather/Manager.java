package com.gem.weather.screen.main.listweather;

import android.content.Context;
import android.location.Location;
import android.support.v7.widget.RecyclerView;

import com.gem.weather.rest.dto.WeatherCountryDTO;

/**
 * Created by HoaPham on 5/3/18.
 */

public interface Manager {
  public interface WeatherPresenter {

    WeatherModel getModel();

    void getWeatherData();

    void getWeatherLocation(Location location);
  }

  public interface WeatherView {

    Context getActivityContext();

    void dismissLoading();

    void loading();

    void viewDetailWeather(ItemModel weatherDTO);
  }
}
