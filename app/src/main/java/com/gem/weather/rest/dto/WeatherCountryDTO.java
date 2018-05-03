
package com.gem.weather.rest.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class WeatherCountryDTO extends BaseResponseDTO implements Serializable{

  @SerializedName("coord")
  @Expose
  private CoordDTO coord;
  @SerializedName("weather")
  @Expose
  private List<WeatherDTO> weather = null;
  @SerializedName("base")
  @Expose
  private String base;
  @SerializedName("main")
  @Expose
  private MainInfoDTO main;
  @SerializedName("visibility")
  @Expose
  private Integer visibility;
  @SerializedName("wind")
  @Expose
  private WindDTO wind;
  @SerializedName("clouds")
  @Expose
  private CloudsDTO clouds;
  @SerializedName("dt")
  @Expose
  private Integer dt;
  @SerializedName("sys")
  @Expose
  private SysDTO sys;
  @SerializedName("id")
  @Expose
  private Integer id;
  @SerializedName("name")
  @Expose
  private String name;

  public CoordDTO getCoord() {
    return coord;
  }

  public void setCoord(CoordDTO coord) {
    this.coord = coord;
  }

  public WeatherCountryDTO withCoord(CoordDTO coord) {
    this.coord = coord;
    return this;
  }

  public List<WeatherDTO> getWeather() {
    return weather;
  }

  public void setWeather(List<WeatherDTO> weather) {
    this.weather = weather;
  }

  public WeatherCountryDTO withWeather(List<WeatherDTO> weather) {
    this.weather = weather;
    return this;
  }

  public String getBase() {
    return base;
  }

  public void setBase(String base) {
    this.base = base;
  }

  public WeatherCountryDTO withBase(String base) {
    this.base = base;
    return this;
  }

  public MainInfoDTO getMain() {
    return main;
  }

  public void setMain(MainInfoDTO main) {
    this.main = main;
  }

  public WeatherCountryDTO withMain(MainInfoDTO main) {
    this.main = main;
    return this;
  }

  public Integer getVisibility() {
    return visibility;
  }

  public void setVisibility(Integer visibility) {
    this.visibility = visibility;
  }

  public WeatherCountryDTO withVisibility(Integer visibility) {
    this.visibility = visibility;
    return this;
  }

  public WindDTO getWind() {
    return wind;
  }

  public void setWind(WindDTO wind) {
    this.wind = wind;
  }

  public WeatherCountryDTO withWind(WindDTO wind) {
    this.wind = wind;
    return this;
  }

  public CloudsDTO getClouds() {
    return clouds;
  }

  public void setClouds(CloudsDTO clouds) {
    this.clouds = clouds;
  }

  public WeatherCountryDTO withClouds(CloudsDTO clouds) {
    this.clouds = clouds;
    return this;
  }

  public Integer getDt() {
    return dt;
  }

  public void setDt(Integer dt) {
    this.dt = dt;
  }

  public WeatherCountryDTO withDt(Integer dt) {
    this.dt = dt;
    return this;
  }

  public SysDTO getSys() {
    return sys;
  }

  public void setSys(SysDTO sys) {
    this.sys = sys;
  }

  public WeatherCountryDTO withSys(SysDTO sys) {
    this.sys = sys;
    return this;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public WeatherCountryDTO withId(Integer id) {
    this.id = id;
    return this;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public WeatherCountryDTO withName(String name) {
    this.name = name;
    return this;
  }
}
