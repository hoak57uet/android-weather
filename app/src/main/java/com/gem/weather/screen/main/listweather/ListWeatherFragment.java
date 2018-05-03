package com.gem.weather.screen.main.listweather;

import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.gem.weather.R;
import com.gem.weather.screen.detail.WeatherDetailActivity;
import com.gem.weather.utility.AlertDialogUtils;
import com.gem.weather.utility.Constanst;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

/**
 * Created by HoaPham on 5/3/18.
 */

public class ListWeatherFragment extends Fragment implements Manager.WeatherView, View.OnClickListener {
  private static final int MY_PERMISSIONS_REQUEST_LOCATION = 9999;
  private Manager.WeatherPresenter presenter;
  private ReloadListener reloadListener;
  private RelativeLayout mLoadingRl;
  private FusedLocationProviderClient mFusedLocationClient;


  @Override
  public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    presenter = new WeatherPresenterImpl(this);
    mFusedLocationClient = LocationServices.getFusedLocationProviderClient(getActivityContext());
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

    v.findViewById(R.id.list_current_location_btn).setOnClickListener(this);
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
  public void onClick(View v) {
    switch (v.getId()) {
      case R.id.list_current_location_btn:
        getCurrentLocation();
        break;
    }
  }

  private void getCurrentLocation() {
    if (ActivityCompat.checkSelfPermission(getActivityContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
        && ActivityCompat.checkSelfPermission(getActivityContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
      ActivityCompat.requestPermissions(getActivity(),
          new String[]{Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION},
          MY_PERMISSIONS_REQUEST_LOCATION);
      return;
    }
    mFusedLocationClient.getLastLocation()
        .addOnSuccessListener(getActivity(), new OnSuccessListener<Location>() {
          @Override
          public void onSuccess(Location location) {
            if (location != null) {
            }
          }
        });
  }

  @Override
  public void onDestroy() {
    getActivity().unregisterReceiver(reloadListener);
    super.onDestroy();
  }

  @Override
  public void viewDetailWeather(ItemModel item) {
    Intent detailIntent = new Intent(getActivityContext(), WeatherDetailActivity.class);
    detailIntent.putExtra(Constanst.KEY_WEATHER_DETAIL, item.getLocationName());
    startActivity(detailIntent);
  }

  @Override
  public void onRequestPermissionsResult(int requestCode,
                                         String permissions[], int[] grantResults) {
    switch (requestCode) {
      case MY_PERMISSIONS_REQUEST_LOCATION: {
        // If request is cancelled, the result arrays are empty.
        if (grantResults.length > 0
            && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
          // permission was granted, yay! Do the
          // contacts-related task you need to do.
        } else {
          // permission denied, boo! Disable the
          // functionality that depends on this permission.
        }
        return;
      }

      // other 'case' lines to check for other
      // permissions this app might request.
    }
  }
}
