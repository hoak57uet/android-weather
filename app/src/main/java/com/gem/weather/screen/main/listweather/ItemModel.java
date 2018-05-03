package com.gem.weather.screen.main.listweather;

/**
 * Created by HoaPham on 5/3/18.
 */

public class ItemModel {
  private String locationName;
  private String actualWeather;
  private Double temp;

  public ItemModel() {
  }

  public ItemModel(String locationName, String actualWeather, Double temp) {
    this.locationName = locationName;
    this.actualWeather = actualWeather;
    this.temp = temp;
  }

  public String getLocationName() {
    return locationName;
  }

  public ItemModel setLocationName(String locationName) {
    this.locationName = locationName;
    return this;
  }

  public String getActualWeather() {
    return actualWeather;
  }

  public ItemModel setActualWeather(String actualWeather) {
    this.actualWeather = actualWeather;
    return this;
  }

  public Double getTemp() {
    return temp;
  }

  public ItemModel setTemp(Double temp) {
    this.temp = temp;
    return this;
  }
}
