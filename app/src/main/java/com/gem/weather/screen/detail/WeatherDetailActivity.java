package com.gem.weather.screen.detail;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.gem.weather.R;
import com.gem.weather.rest.dto.MainInfoDTO;
import com.gem.weather.rest.dto.WeatherCountryDTO;
import com.gem.weather.rest.dto.WeatherDTO;
import com.gem.weather.rest.dto.WindDTO;
import com.gem.weather.utility.Constanst;
import com.gem.weather.utility.DateTimeUtils;
import com.gem.weather.utility.NumberUtils;
import com.gem.weather.utility.TemperatureUtils;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by HoaPham on 5/3/18.
 */

public class WeatherDetailActivity extends AppCompatActivity implements Manager.WeatherDetailView, View.OnClickListener {
  private Manager.WeatherDetailPresenter presenter;

  private TextView mTimeTv;
  private TextView mTemperatureTv;
  private ImageView mIconImg;
  private TextView mActualWeatherTv;
  private TextView mLocationNameTv;
  private TextView mHumidityTv;
  private TextView mPressureTv;
  private TextView mWindSpeedTv;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_weather_detail);
    initView();
    presenter = new WeatherDetailPresenterImpl(this);
    presenter.getDetailWeather();

  }

  private void initView() {
    mTimeTv = findViewById(R.id.detail_time_tv);
    mTemperatureTv = findViewById(R.id.detail_temp_tv);
    mIconImg = findViewById(R.id.detail_icon_img);
    mActualWeatherTv = findViewById(R.id.detail_actual_weather_tv);
    mLocationNameTv = findViewById(R.id.detail_location_name_tv);
    mHumidityTv = findViewById(R.id.detail_humidity_tv);
    mPressureTv = findViewById(R.id.detail_pressure_tv);
    mWindSpeedTv = findViewById(R.id.detail_wind_speed_tv);

    findViewById(R.id.detail_reload_img).setOnClickListener(this);
    findViewById(R.id.detail_back_img).setOnClickListener(this);
  }

  @Override
  public void updateDetailView(WeatherCountryDTO weatherCountryDTO) {
    mTimeTv.setText(DateTimeUtils.showNow());
    mLocationNameTv.setText(weatherCountryDTO.getName());

    MainInfoDTO main = weatherCountryDTO.getMain();
    if (main != null) {
      mTemperatureTv.setText(TemperatureUtils.toString(weatherCountryDTO.getMain().getTemp()));
      mHumidityTv.setText(NumberUtils.formatPercent(main.getHumidity()));
      mPressureTv.setText(NumberUtils.getPressure(main.getPressure()));
    }
    //wind
    WindDTO windDTO = weatherCountryDTO.getWind();
    if (windDTO != null) {
      mWindSpeedTv.setText(NumberUtils.getWindSpeed(windDTO.getSpeed()));
    }
    List<WeatherDTO> weatherDTOS = weatherCountryDTO.getWeather();
    if (weatherDTOS != null && !weatherDTOS.isEmpty()) {
      mActualWeatherTv.setText(weatherDTOS.get(0).getDescription());
      String icon = weatherDTOS.get(0).getIcon();
      Picasso.get().load(String.format(Constanst.ICON_FULL_URL, icon)).into(mIconImg);
    }
  }

  @Override
  public void onClick(View v) {
    switch (v.getId()) {
      case R.id.detail_reload_img:
        presenter.getDetailWeather();
        break;
      case R.id.detail_back_img:
        finish();
        break;
    }
  }

  @Override
  public AppCompatActivity getContextActivity() {
    return this;
  }
}
