package com.gem.weather.rest.dto;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by HoaPham on 5/3/18.
 */

public class ListWeatherCountryDTO {
  private Integer cnt;
  @SerializedName("list")
  private List<WeatherCountryDTO> weathers;


  public Integer getCnt() {
    return cnt;
  }

  public ListWeatherCountryDTO setCnt(Integer cnt) {
    this.cnt = cnt;
    return this;
  }

  public List<WeatherCountryDTO> getWeathers() {
    return weathers;
  }

  public ListWeatherCountryDTO setWeathers(List<WeatherCountryDTO> weathers) {
    this.weathers = weathers;
    return this;
  }
}
