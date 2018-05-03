package com.gem.weather.rest.dto;

import java.io.Serializable;

/**
 * Created by HoaPham on 5/3/18.
 */

public class BaseResponseDTO implements Serializable{
  private Integer cod;

  public Integer getCod() {
    return cod;
  }

  public BaseResponseDTO setCod(Integer cod) {
    this.cod = cod;
    return this;
  }
}
