package com.gem.weather.screen.main.reload;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gem.weather.R;
import com.gem.weather.utility.Constanst;

/**
 * Created by HoaPham on 5/3/18.
 */

public class ReloadFragment extends Fragment implements View.OnClickListener {
  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    View v = inflater.inflate(R.layout.fragment_reload_button, container, false);
    v.findViewById(R.id.reload_btn).setOnClickListener(this);
    return v;
  }

  @Override
  public void onClick(View v) {
    switch (v.getId()) {
      case R.id.reload_btn:
        reloadListWeather();
        break;
    }
  }

  private void reloadListWeather() {
    getActivity().sendBroadcast(new Intent(Constanst.SIG_RELOAD_WEATHER_LIST));
  }
}
