package com.gem.weather.screen.main.listweather;

import com.gem.weather.rest.BaseCallback;
import com.gem.weather.rest.ServiceBuilder;
import com.gem.weather.rest.dto.ListWeatherCountryDTO;
import com.gem.weather.rest.dto.WeatherCountryDTO;
import com.gem.weather.utility.AlertDialogUtils;
import com.gem.weather.utility.Mapper;

import java.util.List;

/**
 * Created by HoaPham on 5/3/18.
 */

public class WeatherPresenterImpl implements Manager.WeatherPresenter, WeatherAdapter.OnItemClickListener {
  private Manager.WeatherView weatherView;
  private WeatherModel model;

  public WeatherPresenterImpl(Manager.WeatherView weatherView) {
    this.weatherView = weatherView;
    model = new WeatherModel();
    model.setOnItemClickListener(this);
  }

  @Override
  public void getWeatherData() {
    ServiceBuilder.getWeatherService().getWeatherOfSeveralCountries(model.getListCityIds())
        .enqueue(new BaseCallback<ListWeatherCountryDTO>() {

          @Override
          public void success(ListWeatherCountryDTO data) {
            model.setWeatherItems(Mapper.convertToModel(data));
          }

          @Override
          public void error(String message) {
            AlertDialogUtils.showError(weatherView.getActivityContext(), message);
          }
        });
  }

  @Override
  public void onItemClicked(int position) {
    //pass to detail activity
    ListWeatherCountryDTO listWeatherCountryDTO = model.getListWeatherCountryDTO();
    if (listWeatherCountryDTO == null)
      return;
    List<WeatherCountryDTO> weatherCountryDTOS = listWeatherCountryDTO.getWeathers();
    if (weatherCountryDTOS == null || weatherCountryDTOS.isEmpty())
      return;
    WeatherCountryDTO weatherDTO = weatherCountryDTOS.get(position);
  }

  @Override
  public WeatherModel getModel() {
    return model;
  }

  public WeatherPresenterImpl setModel(WeatherModel model) {
    this.model = model;
    return this;
  }
}
