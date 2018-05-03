package com.gem.weather.screen.main.listweather;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.gem.weather.R;
import com.gem.weather.rest.dto.WeatherCountryDTO;
import com.gem.weather.screen.detail.WeatherDetailActivity;
import com.gem.weather.utility.AlertDialogUtils;
import com.gem.weather.utility.Constanst;

/**
 * Created by HoaPham on 5/3/18.
 */

public class ListWeatherFragment extends Fragment implements Manager.WeatherView {
  private Manager.WeatherPresenter presenter;
  private ReloadListener reloadListener;
  private RelativeLayout mLoadingRl;

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
    mLoadingRl = v.findViewById(R.id.list_weather_loading_rl);
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
    reloadListener = new ReloadListener();
    getActivity().registerReceiver(reloadListener, new IntentFilter(Constanst.SIG_RELOAD_WEATHER_LIST));
  }

  @Override
  public void dismissLoading() {
    AlertDialogUtils.dismissLoading();
//    mLoadingRl.setVisibility(View.GONE);
  }

  @Override
  public void loading() {
    AlertDialogUtils.showLoading(getActivityContext());
//    mLoadingRl.setVisibility(View.VISIBLE);
  }

  @Override
  public Context getActivityContext() {
    return getActivity();
  }

  private class ReloadListener extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
      presenter.getWeatherData();
    }
  }

  @Override
  public void onDestroy() {
    getActivity().unregisterReceiver(reloadListener);
    super.onDestroy();
  }

  @Override
  public void viewDetailWeather(WeatherCountryDTO weatherDTO) {
    Intent detailIntent = new Intent(getActivityContext(), WeatherDetailActivity.class);
    detailIntent.putExtra(Constanst.KEY_WEATHER_DETAIL, weatherDTO.getName());
    startActivity(detailIntent);
  }
}
