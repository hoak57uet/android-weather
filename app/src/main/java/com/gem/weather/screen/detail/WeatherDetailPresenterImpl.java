package com.gem.weather.screen.detail;

import com.gem.weather.rest.BaseCallback;
import com.gem.weather.rest.ServiceBuilder;
import com.gem.weather.rest.dto.WeatherCountryDTO;
import com.gem.weather.utility.AlertDialogUtils;
import com.gem.weather.utility.Constanst;

/**
 * Created by HoaPham on 5/3/18.
 */

public class WeatherDetailPresenterImpl implements Manager.WeatherDetailPresenter {
  private Manager.WeatherDetailView detailView;
  private String cityName;

  public WeatherDetailPresenterImpl(Manager.WeatherDetailView detailView) {
    this.detailView = detailView;
    cityName = detailView.getContextActivity()
        .getIntent().getStringExtra(Constanst.KEY_WEATHER_DETAIL);
  }

  @Override
  public void getDetailWeather() {
    if (cityName == null)
      return;
    AlertDialogUtils.showLoading(detailView.getContextActivity());
    ServiceBuilder.getWeatherService().getWeatherOfCountries(cityName)
        .enqueue(new BaseCallback<WeatherCountryDTO>() {
          @Override
          public void success(WeatherCountryDTO data) {
            AlertDialogUtils.dismissLoading();
            cityName = data.getName();
            detailView.updateDetailView(data);
          }

          @Override
          public void error(String message) {
            AlertDialogUtils.dismissLoading();
          }
        });
  }
}
