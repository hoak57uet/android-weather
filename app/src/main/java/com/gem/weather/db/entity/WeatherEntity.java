package com.gem.weather.db.entity;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by HoaPham on 5/4/18.
 */

public class WeatherEntity extends RealmObject {
  private Double lat;
  private Double lng;
  private Integer weather_id;
  private String weather_main;
  private String weather_desc;
  private String weather_icon;
  private String base;
  private Double main_temp;
  private Double main_pressure;
  private Double main_humidity;
  private Double main_temp_min;
  private Double main_temp_max;
  private Double main_sea_level;
  private Double main_grnd_level;
  private Double wind_speed;
  private Double wind_deg;
  private Double clouds_all;
  private Long dt;
  private Double sys_message;
  private String sys_country;
  private Long sys_sunrise;
  private Long sys_sunset;
  @PrimaryKey
  private Long id;
  private String name;
  private Integer cod;

  public Double getLat() {
    return lat;
  }

  public WeatherEntity setLat(Double lat) {
    this.lat = lat;
    return this;
  }

  public Double getLng() {
    return lng;
  }

  public WeatherEntity setLng(Double lng) {
    this.lng = lng;
    return this;
  }

  public Integer getWeather_id() {
    return weather_id;
  }

  public WeatherEntity setWeather_id(Integer weather_id) {
    this.weather_id = weather_id;
    return this;
  }

  public String getWeather_main() {
    return weather_main;
  }

  public WeatherEntity setWeather_main(String weather_main) {
    this.weather_main = weather_main;
    return this;
  }

  public String getWeather_desc() {
    return weather_desc;
  }

  public WeatherEntity setWeather_desc(String weather_desc) {
    this.weather_desc = weather_desc;
    return this;
  }

  public String getWeather_icon() {
    return weather_icon;
  }

  public WeatherEntity setWeather_icon(String weather_icon) {
    this.weather_icon = weather_icon;
    return this;
  }

  public String getBase() {
    return base;
  }

  public WeatherEntity setBase(String base) {
    this.base = base;
    return this;
  }

  public Double getMain_temp() {
    return main_temp;
  }

  public WeatherEntity setMain_temp(Double main_temp) {
    this.main_temp = main_temp;
    return this;
  }

  public Double getMain_pressure() {
    return main_pressure;
  }

  public WeatherEntity setMain_pressure(Double main_pressure) {
    this.main_pressure = main_pressure;
    return this;
  }

  public Double getMain_humidity() {
    return main_humidity;
  }

  public WeatherEntity setMain_humidity(Double main_humidity) {
    this.main_humidity = main_humidity;
    return this;
  }

  public Double getMain_temp_min() {
    return main_temp_min;
  }

  public WeatherEntity setMain_temp_min(Double main_temp_min) {
    this.main_temp_min = main_temp_min;
    return this;
  }

  public Double getMain_temp_max() {
    return main_temp_max;
  }

  public WeatherEntity setMain_temp_max(Double main_temp_max) {
    this.main_temp_max = main_temp_max;
    return this;
  }

  public Double getMain_sea_level() {
    return main_sea_level;
  }

  public WeatherEntity setMain_sea_level(Double main_sea_level) {
    this.main_sea_level = main_sea_level;
    return this;
  }

  public Double getMain_grnd_level() {
    return main_grnd_level;
  }

  public WeatherEntity setMain_grnd_level(Double main_grnd_level) {
    this.main_grnd_level = main_grnd_level;
    return this;
  }

  public Double getWind_speed() {
    return wind_speed;
  }

  public WeatherEntity setWind_speed(Double wind_speed) {
    this.wind_speed = wind_speed;
    return this;
  }

  public Double getWind_deg() {
    return wind_deg;
  }

  public WeatherEntity setWind_deg(Double wind_deg) {
    this.wind_deg = wind_deg;
    return this;
  }

  public Double getClouds_all() {
    return clouds_all;
  }

  public WeatherEntity setClouds_all(Double clouds_all) {
    this.clouds_all = clouds_all;
    return this;
  }

  public Long getDt() {
    return dt;
  }

  public WeatherEntity setDt(Long dt) {
    this.dt = dt;
    return this;
  }

  public Double getSys_message() {
    return sys_message;
  }

  public WeatherEntity setSys_message(Double sys_message) {
    this.sys_message = sys_message;
    return this;
  }

  public String getSys_country() {
    return sys_country;
  }

  public WeatherEntity setSys_country(String sys_country) {
    this.sys_country = sys_country;
    return this;
  }

  public Long getSys_sunrise() {
    return sys_sunrise;
  }

  public WeatherEntity setSys_sunrise(Long sys_sunrise) {
    this.sys_sunrise = sys_sunrise;
    return this;
  }

  public Long getSys_sunset() {
    return sys_sunset;
  }

  public WeatherEntity setSys_sunset(Long sys_sunset) {
    this.sys_sunset = sys_sunset;
    return this;
  }

  public Long getId() {
    return id;
  }

  public WeatherEntity setId(Long id) {
    this.id = id;
    return this;
  }

  public String getName() {
    return name;
  }

  public WeatherEntity setName(String name) {
    this.name = name;
    return this;
  }

  public Integer getCod() {
    return cod;
  }

  public WeatherEntity setCod(Integer cod) {
    this.cod = cod;
    return this;
  }
}
