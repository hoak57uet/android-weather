package com.gem.weather.screen.main.listweather;

import android.os.AsyncTask;

import com.gem.weather.db.entity.WeatherEntity;
import com.gem.weather.rest.BaseCallback;
import com.gem.weather.rest.ServiceBuilder;
import com.gem.weather.rest.dto.ListWeatherCountryDTO;
import com.gem.weather.rest.dto.WeatherCountryDTO;
import com.gem.weather.utility.AlertDialogUtils;
import com.gem.weather.utility.Mapper;
import com.gem.weather.utility.NetworkUtils;
import com.gem.weather.utility.RealmUtils;

import java.util.List;

import io.realm.Realm;

/**
 * Created by HoaPham on 5/3/18.
 */

public class WeatherPresenterImpl implements Manager.WeatherPresenter {
  private Manager.WeatherView weatherView;
  private WeatherModel model;

  public WeatherPresenterImpl(Manager.WeatherView weatherView) {
    this.weatherView = weatherView;
    model = new WeatherModel();
    model.setOnItemClickListener(new OnItemClicked());
  }

  @Override
  public void getWeatherData() {
    if (NetworkUtils.isNetworkAvailable()){
      getDataWithNetwork();
    }else {
      getDataWithoutNetwork();
    }
  }

  private void getDataWithoutNetwork() {
    Realm realm = RealmUtils.getInstance();
    realm.beginTransaction();
    List<WeatherEntity> entities = realm.where(WeatherEntity.class).findAll();
    model.setWeatherItems(Mapper.convertToModel(entities));
    realm.commitTransaction();
  }

  private void getDataWithNetwork() {
    weatherView.loading();
    ServiceBuilder.getWeatherService().getWeatherOfSeveralCountries(model.getListCityIds())
        .enqueue(new BaseCallback<ListWeatherCountryDTO>() {

          @Override
          public void success(ListWeatherCountryDTO data) {
            weatherView.dismissLoading();
            model.setWeatherItems(Mapper.convertToModel(data));
            saveToDB(data);
          }

          @Override
          public void error(String message) {
            weatherView.dismissLoading();
            AlertDialogUtils.showError(weatherView.getActivityContext(), message);
          }
        });
  }

  private void saveToDB(final ListWeatherCountryDTO data) {
    new AsyncTask<Void, Void, Void>() {
      @Override
      protected Void doInBackground(Void... voids) {
        Realm realm = RealmUtils.getInstance();
        //delete old records and save new records:
        realm.beginTransaction();
        realm.delete(WeatherEntity.class);
        List<WeatherEntity> weatherEntities = Mapper.dto2Entity(data);
        realm.copyToRealm(weatherEntities);
        realm.commitTransaction();
        return null;
      }
    }.execute();
  }

  private class OnItemClicked implements WeatherAdapter.OnItemClickListener {
    @Override
    public void onItemClicked(ItemModel model) {
      weatherView.viewDetailWeather(model);
    }
  }

  @Override
  public WeatherModel getModel() {
    return model;
  }

  public WeatherPresenterImpl setModel(WeatherModel model) {
    this.model = model;
    return this;
  }
}
