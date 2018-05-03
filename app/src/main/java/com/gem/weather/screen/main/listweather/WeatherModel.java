package com.gem.weather.screen.main.listweather;

import com.gem.weather.rest.dto.ListWeatherCountryDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HoaPham on 5/3/18.
 */

public class WeatherModel {
  private List<ItemModel> items;
  private ListWeatherCountryDTO listWeatherCountryDTO;
  private WeatherAdapter listWeatherAdapter;
  private final String listCityIds = "2643743,3067696,5391959";

  public WeatherModel() {
    items = new ArrayList<>();
    listWeatherAdapter = new WeatherAdapter(items);
  }

  public List<ItemModel> getItems() {
    return items;
  }

  public WeatherModel setItems(List<ItemModel> items) {
    this.items = items;
    return this;
  }

  public WeatherAdapter getListWeatherAdapter() {
    return listWeatherAdapter;
  }

  public WeatherModel setListWeatherAdapter(WeatherAdapter listWeatherAdapter) {
    this.listWeatherAdapter = listWeatherAdapter;
    return this;
  }

  public void addWeatherItem(List<ItemModel> models) {
    items.addAll(models);
    listWeatherAdapter.notifyDataSetChanged();
  }

  public void setWeatherItems(List<ItemModel> models) {
    items.clear();
    items.addAll(models);
    listWeatherAdapter.notifyDataSetChanged();
  }

  public String getListCityIds() {
    return listCityIds;
  }

  public ListWeatherCountryDTO getListWeatherCountryDTO() {
    return listWeatherCountryDTO;
  }

  public WeatherModel setListWeatherCountryDTO(ListWeatherCountryDTO listWeatherCountryDTO) {
    this.listWeatherCountryDTO = listWeatherCountryDTO;
    return this;
  }

  public void setOnItemClickListener(WeatherAdapter.OnItemClickListener listener) {
    listWeatherAdapter.setOnItemClickListener(listener);
  }
}
