package com.gem.weather.rest.dto;

/**
 * Created by HoaPham on 5/3/18.
 */

public class BaseResponseDTO {
  private Integer cod;

  public Integer getCod() {
    return cod;
  }

  public BaseResponseDTO setCod(Integer cod) {
    this.cod = cod;
    return this;
  }
}
