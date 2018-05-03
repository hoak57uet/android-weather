package com.gem.weather.screen.main.listweather;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gem.weather.R;

/**
 * Created by HoaPham on 5/3/18.
 */

public class ListWeatherFragment extends Fragment implements Manager.WeatherView {
  private Manager.WeatherPresenter presenter;

  @Override
  public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    presenter = new WeatherPresenterImpl(this);
  }

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    View v = inflater.inflate(R.layout.fragment_list_weather, container, false);
    RecyclerView mListWeatherRv = v.findViewById(R.id.list_weather_rv);
    mListWeatherRv.setHasFixedSize(true);
    mListWeatherRv.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
    mListWeatherRv.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
    mListWeatherRv.setAdapter(presenter.getModel().getListWeatherAdapter());
    return v;
  }

  @Override
  public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    presenter.getWeatherData();
  }

  @Override
  public Context getActivityContext() {
    return getActivity();
  }
}
