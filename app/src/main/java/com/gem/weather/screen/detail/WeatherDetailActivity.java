package com.gem.weather.screen.detail;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.gem.weather.R;
import com.gem.weather.utility.Constanst;
import com.gem.weather.utility.DateTimeUtils;
import com.gem.weather.utility.NumberUtils;
import com.gem.weather.utility.TemperatureUtils;
import com.squareup.picasso.Picasso;

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
  public void updateDetailView(DetailModel model) {
    mTimeTv.setText(DateTimeUtils.showNow());
    mLocationNameTv.setText(model.getName());

    mTemperatureTv.setText(TemperatureUtils.toString(model.getMainTemp()));
    mHumidityTv.setText(NumberUtils.formatPercent(model.getMainHumidity()));
    mPressureTv.setText(NumberUtils.getPressure(model.getMainPressure()));
    //wind
    mWindSpeedTv.setText(NumberUtils.getWindSpeed(model.getWindSpeed()));
    mActualWeatherTv.setText(model.getWeatherDesc());
    String icon = model.getWeatherIcon();
    Picasso.get().load(String.format(Constanst.ICON_FULL_URL, icon)).into(mIconImg);
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
