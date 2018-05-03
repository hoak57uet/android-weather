package com.gem.weather.screen.main;

/**
 * Created by HoaPham on 5/3/18.
 */

public class WeatherModel {
  private String locationName;
  private String actualWeather;
  private Double temp;

  public String getLocationName() {
    return locationName;
  }

  public WeatherModel setLocationName(String locationName) {
    this.locationName = locationName;
    return this;
  }

  public String getActualWeather() {
    return actualWeather;
  }

  public WeatherModel setActualWeather(String actualWeather) {
    this.actualWeather = actualWeather;
    return this;
  }

  public Double getTemp() {
    return temp;
  }

  public WeatherModel setTemp(Double temp) {
    this.temp = temp;
    return this;
  }
}
