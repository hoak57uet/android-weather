package com.gem.weather.screen.detail;

/**
 * Created by HoaPham on 5/4/18.
 */

public class DetailModel {
  private String weatherMain;
  private String weatherDesc;
  private Double mainTemp;
  private Double mainPressure;
  private Double mainHumidity;
  private Double windSpeed;
  private String name;
  private String weatherIcon;

  public String getWeatherMain() {
    return weatherMain;
  }

  public DetailModel setWeatherMain(String weatherMain) {
    this.weatherMain = weatherMain;
    return this;
  }

  public String getWeatherDesc() {
    return weatherDesc;
  }

  public DetailModel setWeatherDesc(String weatherDesc) {
    this.weatherDesc = weatherDesc;
    return this;
  }

  public Double getMainTemp() {
    return mainTemp;
  }

  public DetailModel setMainTemp(Double mainTemp) {
    this.mainTemp = mainTemp;
    return this;
  }

  public Double getMainPressure() {
    return mainPressure;
  }

  public DetailModel setMainPressure(Double mainPressure) {
    this.mainPressure = mainPressure;
    return this;
  }

  public Double getMainHumidity() {
    return mainHumidity;
  }

  public DetailModel setMainHumidity(Double mainHumidity) {
    this.mainHumidity = mainHumidity;
    return this;
  }

  public Double getWindSpeed() {
    return windSpeed;
  }

  public DetailModel setWindSpeed(Double windSpeed) {
    this.windSpeed = windSpeed;
    return this;
  }

  public String getName() {
    return name;
  }

  public DetailModel setName(String name) {
    this.name = name;
    return this;
  }

  public String getWeatherIcon() {
    return weatherIcon;
  }

  public DetailModel setWeatherIcon(String weatherIcon) {
    this.weatherIcon = weatherIcon;
    return this;
  }
}
