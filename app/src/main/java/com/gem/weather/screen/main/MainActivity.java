package com.gem.weather.screen.main;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.gem.weather.R;
import com.gem.weather.rest.dto.WeatherCountryDTO;
import com.gem.weather.utility.AlertDialogUtils;

/**
 * Created by HoaPham on 5/3/18.
 */

public class MainActivity extends AppCompatActivity implements Manager.MainView {
  private Manager.MainPresenter presenter;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    presenter = new MainPresenterImpl(this);
    presenter.getWeatherData();
  }

  @Override
  public void getWeatherDataSuccess(WeatherCountryDTO data) {
    AlertDialogUtils.showError(this, data.toString());
  }

  @Override
  public Context getContext() {
    return this;
  }
}
