package com.gem.weather.screen.main;

import com.gem.weather.rest.BaseCallback;
import com.gem.weather.rest.ServiceBuilder;
import com.gem.weather.rest.dto.WeatherCountryDTO;
import com.gem.weather.screen.main.listweather.WeatherModel;
import com.gem.weather.utility.AlertDialogUtils;

import java.util.List;

/**
 * Created by HoaPham on 5/3/18.
 */

public class MainPresenterImpl implements Manager.MainPresenter {
  private Manager.MainView mainView;
  private List<WeatherModel> weathers;

  public MainPresenterImpl(Manager.MainView mainView) {
    this.mainView = mainView;
  }

  @Override
  public void getWeatherData() {
    ServiceBuilder.getWeatherService().getWeatherOfCountries("London")
        .enqueue(new BaseCallback<WeatherCountryDTO>() {

          @Override
          public void success(WeatherCountryDTO data) {
            mainView.getWeatherDataSuccess(data);
          }

          @Override
          public void error(String message) {
            AlertDialogUtils.showError(mainView.getContext(), message);
          }
        });
  }
}
