package com.gem.weather.utility;

import com.gem.weather.db.entity.WeatherEntity;
import com.gem.weather.rest.dto.CloudsDTO;
import com.gem.weather.rest.dto.CoordDTO;
import com.gem.weather.rest.dto.ListWeatherCountryDTO;
import com.gem.weather.rest.dto.MainInfoDTO;
import com.gem.weather.rest.dto.SysDTO;
import com.gem.weather.rest.dto.WeatherCountryDTO;
import com.gem.weather.rest.dto.WeatherDTO;
import com.gem.weather.rest.dto.WindDTO;
import com.gem.weather.screen.detail.DetailModel;
import com.gem.weather.screen.main.listweather.ItemModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HoaPham on 5/3/18.
 */

public class Mapper {
  public static List<ItemModel> convertToModel(List<WeatherEntity> entities) {
    List<ItemModel> models = new ArrayList<>();
    for (WeatherEntity e : entities) {
      models.add(entity2ItemModel(e));
    }
    return models;
  }

  private static ItemModel entity2ItemModel(WeatherEntity e) {
    return new ItemModel()
        .setLocationName(e.getName())
        .setTemp(e.getMain_temp())
        .setActualWeather(e.getWeather_main());
  }

  public static List<ItemModel> convertToModel(ListWeatherCountryDTO list) {
    List<ItemModel> models = new ArrayList<>();
    if (list == null)
      return models;
    for (WeatherCountryDTO w : list.getWeathers()) {
      ItemModel model = new ItemModel();
      model.setLocationName(w.getName());
      List<WeatherDTO> weathers = w.getWeather();
      if (weathers != null && !weathers.isEmpty()) {
        model.setActualWeather(weathers.get(0).getMain());
      }
      if (w.getMain() != null) {
        model.setTemp(w.getMain().getTemp());
      }
      models.add(model);
    }
    return models;
  }

  public static List<WeatherEntity> dto2Entity(ListWeatherCountryDTO list) {
    List<WeatherEntity> entities = new ArrayList<>();
    for (WeatherCountryDTO dto : list.getWeathers()) {
      entities.add(dto2Entity(dto));
    }
    return entities;
  }

  public static WeatherEntity dto2Entity(WeatherCountryDTO dto) {
    WeatherEntity entity = new WeatherEntity();
    entity.setBase(dto.getBase())
        .setId(dto.getId())
        .setName(dto.getName())
        .setCod(dto.getCod());
    //convert coord
    CoordDTO coordDTO = dto.getCoord();
    if (coordDTO != null) {
      entity.setLat(coordDTO.getLat())
          .setLng(coordDTO.getLon());
    }
    //convert weather
    if (dto.getWeather() != null && !dto.getWeather().isEmpty()) {
      WeatherDTO weatherDTO = dto.getWeather().get(0);
      entity.setWeather_id(weatherDTO.getId())
          .setWeather_main(weatherDTO.getMain())
          .setWeather_icon(weatherDTO.getIcon())
          .setWeather_desc(weatherDTO.getDescription());
    }
    //convert main
    MainInfoDTO main = dto.getMain();
    if (main != null) {
      entity.setMain_temp(main.getTemp())
          .setMain_pressure(main.getPressure())
          .setMain_humidity(main.getHumidity())
          .setMain_temp_min(main.getTempMin())
          .setMain_temp_min(main.getTempMax());
    }
    //wind
    WindDTO windDTO = dto.getWind();
    if (windDTO != null) {
      entity.setWind_speed(windDTO.getSpeed())
          .setWind_deg(windDTO.getDeg());
    }
    //clouds
    CloudsDTO cloudsDTO = dto.getClouds();
    if (cloudsDTO != null) {
      entity.setClouds_all(cloudsDTO.getAll());
    }
    SysDTO sysDTO = dto.getSys();
    if (sysDTO != null) {
      entity.setSys_message(sysDTO.getMessage())
          .setSys_country(sysDTO.getCountry())
          .setSys_sunrise(sysDTO.getSunrise())
          .setSys_sunset(sysDTO.getSunset());
    }
    return entity;
  }

  public static DetailModel detailDTO2Model(WeatherCountryDTO data) {
    DetailModel model = new DetailModel();
    MainInfoDTO mainInfoDTO = data.getMain();
    if (mainInfoDTO != null) {
      model.setMainTemp(mainInfoDTO.getTemp())
          .setMainHumidity(mainInfoDTO.getHumidity())
          .setMainPressure(mainInfoDTO.getPressure());
    }
    if (data.getWeather() != null && !data.getWeather().isEmpty()) {
      WeatherDTO weatherDTO = data.getWeather().get(0);
      model.setWeatherMain(weatherDTO.getMain())
          .setWeatherDesc(weatherDTO.getDescription())
          .setWeatherIcon(weatherDTO.getIcon());
    }
    WindDTO windDTO = data.getWind();
    if (windDTO != null) {
      model.setWindSpeed(windDTO.getSpeed());
    }
    model.setName(data.getName());

    return model;
  }

  public static DetailModel detailEntity2Model(WeatherEntity entity) {
    if (entity == null)
      return new DetailModel();
    return new DetailModel()
        .setName(entity.getName())
        .setMainTemp(entity.getMain_temp())
        .setMainHumidity(entity.getMain_humidity())
        .setMainPressure(entity.getMain_pressure())
        .setWeatherMain(entity.getWeather_main())
        .setWeatherIcon(entity.getWeather_icon())
        .setWeatherDesc(entity.getWeather_desc())
        .setWindSpeed(entity.getWind_speed());

  }
}
