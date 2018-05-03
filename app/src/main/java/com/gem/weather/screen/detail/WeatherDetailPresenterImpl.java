package com.gem.weather.screen.detail;

import android.os.AsyncTask;

import com.gem.weather.db.entity.WeatherEntity;
import com.gem.weather.rest.BaseCallback;
import com.gem.weather.rest.ServiceBuilder;
import com.gem.weather.rest.dto.WeatherCountryDTO;
import com.gem.weather.utility.AlertDialogUtils;
import com.gem.weather.utility.Constanst;
import com.gem.weather.utility.Mapper;
import com.gem.weather.utility.NetworkUtils;
import com.gem.weather.utility.RealmUtils;

import io.realm.Realm;

/**
 * Created by HoaPham on 5/3/18.
 */

public class WeatherDetailPresenterImpl implements Manager.WeatherDetailPresenter {
  private Manager.WeatherDetailView detailView;
  private String cityName;
  private DetailModel model;

  public WeatherDetailPresenterImpl(Manager.WeatherDetailView detailView) {
    this.detailView = detailView;
    model = new DetailModel();
    cityName = detailView.getContextActivity()
        .getIntent().getStringExtra(Constanst.KEY_WEATHER_DETAIL);
    model.setName(cityName);
  }

  @Override
  public void getDetailWeather() {
    if (cityName == null)
      return;
    if (NetworkUtils.isNetworkAvailable()) {
      loadDataWithNetwork();
    } else {
      loadDataWithoutNetwork();
    }
  }

  private void loadDataWithoutNetwork() {
    new AsyncTask<Void, Void, Void>() {
      @Override
      protected void onPreExecute() {
        AlertDialogUtils.showLoading(detailView.getContextActivity());
      }

      @Override
      protected Void doInBackground(Void... voids) {
        Realm realm = RealmUtils.getInstance();
        realm.beginTransaction();
        WeatherEntity e = realm.where(WeatherEntity.class).equalTo("name", cityName).findFirst();
        model = Mapper.detailEntity2Model(e);
        realm.commitTransaction();
        return null;
      }

      @Override
      protected void onPostExecute(Void aVoid) {
        AlertDialogUtils.dismissLoading();
        detailView.updateDetailView(model);
      }
    }.execute();
  }

  private void loadDataWithNetwork() {
    AlertDialogUtils.showLoading(detailView.getContextActivity());
    ServiceBuilder.getWeatherService().getWeatherOfCountries(cityName)
        .enqueue(new BaseCallback<WeatherCountryDTO>() {
          @Override
          public void success(WeatherCountryDTO data) {
            AlertDialogUtils.dismissLoading();
            cityName = data.getName();
            model = Mapper.detailDTO2Model(data);
            detailView.updateDetailView(model);
          }

          @Override
          public void error(String message) {
            AlertDialogUtils.dismissLoading();
          }
        });
  }
}
