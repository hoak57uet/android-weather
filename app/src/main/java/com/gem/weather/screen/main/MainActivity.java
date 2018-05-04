package com.gem.weather.screen.main;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.gem.weather.R;
import com.gem.weather.rest.dto.WeatherCountryDTO;
import com.gem.weather.screen.main.listweather.ListWeatherFragment;
import com.gem.weather.screen.main.reload.ReloadFragment;
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
//    presenter = new MainPresenterImpl(this);
//    presenter.getWeatherData();
    initView();
  }

  private void initView() {
    FragmentTransaction ftr = getSupportFragmentManager().beginTransaction();
    ftr.replace(R.id.main_reload_fl, new ReloadFragment());
    ftr.replace(R.id.main_list_weather_fl, new ListWeatherFragment());
    ftr.commit();
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
