package com.gem.weather.utility;

import com.gem.weather.rest.dto.ListWeatherCountryDTO;
import com.gem.weather.rest.dto.WeatherCountryDTO;
import com.gem.weather.rest.dto.WeatherDTO;
import com.gem.weather.screen.main.listweather.ItemModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HoaPham on 5/3/18.
 */

public class Mapper {
  public static List<ItemModel> convertToModel(ListWeatherCountryDTO list) {
    List<ItemModel> models = new ArrayList<>();
    if (list == null)
      return models;
    for (WeatherCountryDTO w : list.getWeathers()) {
      ItemModel model = new ItemModel();
      model.setLocationName(w.getName());
      List<WeatherDTO> weathers = w.getWeather();
      if (weathers != null && !weathers.isEmpty()) {
        model.setActualWeather(weathers.get(0).getMain());
      }
      if (w.getMain() != null) {
        model.setTemp(w.getMain().getTemp());
      }
      models.add(model);
    }
    return models;
  }
}
