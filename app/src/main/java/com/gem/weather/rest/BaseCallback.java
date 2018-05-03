package com.gem.weather.rest;

import com.gem.weather.rest.dto.BaseResponseDTO;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by HoaPham on 5/3/18.
 */

public abstract class BaseCallback<T extends BaseResponseDTO> implements Callback<T> {
  @Override
  public void onResponse(Call<T> call, Response<T> response) {
    if (!response.isSuccessful()) {
      error("");
      return;
    }
    T data = response.body();
    success(data);
  }

  @Override
  public void onFailure(Call<T> call, Throwable t) {
    error(t.getMessage());
  }

  public abstract void success(T data);

  public abstract void error(String message);
}
