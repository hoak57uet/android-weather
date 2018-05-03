package com.gem.weather.screen.main.listweather;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gem.weather.R;
import com.gem.weather.utility.TemperatureUtils;

import java.util.List;


/**
 * Created by HoaPham on 5/3/18.
 */

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.ViewHolder> {
  private List<ItemModel> items;
  private OnItemClickListener onItemClickListener;

  public WeatherAdapter(List<ItemModel> items) {
    this.items = items;
  }

  @Override
  public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_weather, parent, false));
  }

  @Override
  public void onBindViewHolder(ViewHolder holder, final int position) {
    final ItemModel item = items.get(position);
    holder.mLocationNameTv.setText(item.getLocationName());
    holder.mActualWeatherTv.setText(item.getActualWeather());
    holder.mTemperatureTv.setText(TemperatureUtils.toString(item.getTemp()));

    holder.itemView.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        if (onItemClickListener != null)
          onItemClickListener.onItemClicked(item);
      }
    });
  }

  @Override
  public int getItemCount() {
    return items.size();
  }

  public class ViewHolder extends RecyclerView.ViewHolder {
    TextView mLocationNameTv;
    TextView mActualWeatherTv;
    TextView mTemperatureTv;

    public ViewHolder(View itemView) {
      super(itemView);
      mLocationNameTv = itemView.findViewById(R.id.item_weather_location_name_tv);
      mActualWeatherTv = itemView.findViewById(R.id.item_weather_actual_weather_tv);
      mTemperatureTv = itemView.findViewById(R.id.item_weather_temperature_tv);
    }
  }


  public WeatherAdapter setOnItemClickListener(OnItemClickListener onItemClickListener) {
    this.onItemClickListener = onItemClickListener;
    return this;
  }

  interface OnItemClickListener {
    public void onItemClicked(ItemModel model);
  }
}
