package com.gem.weather.rest;

import com.gem.weather.utility.Constanst;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by HoaPham on 5/3/18.
 */

public class ServiceBuilder {
  private static final String SERVICE_ENDPOINT = "http://api.openweathermap.org/data/2.5/";
  private static Retrofit retrofit;

  private static Retrofit getRetrofit() {
    if (retrofit == null)
      retrofit = new Retrofit.Builder()
          .baseUrl(SERVICE_ENDPOINT)
          .addConverterFactory(GsonConverterFactory.create())
          .client(getHttpClient())
          .build();
    return retrofit;
  }

  public static WeatherService getWeatherService() {
    return getRetrofit().create(WeatherService.class);
  }

  private static OkHttpClient getHttpClient() {
    OkHttpClient.Builder httpClient =
        new OkHttpClient.Builder();
    //add default params api key with all request to openweathermap
    httpClient.addInterceptor(getRequestInterceptor());
    //logging request
    httpClient.addInterceptor(getLoggingInterceptor());
    return httpClient.build();
  }

  private static Interceptor getRequestInterceptor() {
    return new Interceptor() {
      @Override
      public Response intercept(Chain chain) throws IOException {
        Request original = chain.request();
        HttpUrl originalHttpUrl = original.url();

        HttpUrl url = originalHttpUrl.newBuilder()
            .addQueryParameter("appid", Constanst.WEATHER_API_KEY)
            .build();
        Request.Builder requestBuilder = original.newBuilder()
            .url(url);
        Request request = requestBuilder.build();
        return chain.proceed(request);
      }
    };
  }

  private static HttpLoggingInterceptor getLoggingInterceptor() {
    HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
    interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
    return interceptor;
  }
}
