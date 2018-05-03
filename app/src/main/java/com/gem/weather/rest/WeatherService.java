package com.gem.weather.rest;

import com.gem.weather.rest.dto.ListWeatherCountryDTO;
import com.gem.weather.rest.dto.WeatherCountryDTO;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by HoaPham on 5/3/18.
 */

public interface WeatherService {
  @GET("weather")
  Call<WeatherCountryDTO> getWeatherOfCountries(@Query("q") String countries);

  @GET("group")
  Call<ListWeatherCountryDTO> getWeatherOfSeveralCountries(@Query("id") String listOfIds);
}
