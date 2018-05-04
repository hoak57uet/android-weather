
package com.gem.weather.rest.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MainInfoDTO {

  @SerializedName("temp")
  @Expose
  private Double temp;
  @SerializedName("pressure")
  @Expose
  private Double pressure;
  @SerializedName("humidity")
  @Expose
  private Double humidity;
  @SerializedName("temp_min")
  @Expose
  private Double tempMin;
  @SerializedName("temp_max")
  @Expose
  private Double tempMax;

  public Double getTemp() {
    return temp;
  }

  public void setTemp(Double temp) {
    this.temp = temp;
  }

  public MainInfoDTO withTemp(Double temp) {
    this.temp = temp;
    return this;
  }

  public Double getPressure() {
    return pressure;
  }

  public MainInfoDTO setPressure(Double pressure) {
    this.pressure = pressure;
    return this;
  }

  public Double getHumidity() {
    return humidity;
  }

  public void setHumidity(Double humidity) {
    this.humidity = humidity;
  }

  public MainInfoDTO withHumidity(Double humidity) {
    this.humidity = humidity;
    return this;
  }

  public Double getTempMin() {
    return tempMin;
  }

  public void setTempMin(Double tempMin) {
    this.tempMin = tempMin;
  }

  public MainInfoDTO withTempMin(Double tempMin) {
    this.tempMin = tempMin;
    return this;
  }

  public Double getTempMax() {
    return tempMax;
  }

  public void setTempMax(Double tempMax) {
    this.tempMax = tempMax;
  }

  public MainInfoDTO withTempMax(Double tempMax) {
    this.tempMax = tempMax;
    return this;
  }

}
