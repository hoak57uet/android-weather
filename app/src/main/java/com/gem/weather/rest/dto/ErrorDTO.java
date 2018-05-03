package com.gem.weather.rest.dto;

/**
 * Created by HoaPham on 5/3/18.
 */

public class ErrorDTO extends BaseResponseDTO {
  private String message;

  public String getMessage() {
    return message;
  }

  public ErrorDTO setMessage(String message) {
    this.message = message;
    return this;
  }
}
