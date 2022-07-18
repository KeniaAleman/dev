package com.example.weatherapp;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherAPI {

    @GET("weather?appid=4f7a357c46bc2ff211c70edcc02bda")
    Call<OpenWeatherMap>getWeatherWithLocation(@Query("lat")double lat, @Query("long") double lon);

    @GET("weather?appid=4f7a357c46bc2ff211c70edcc02bda55&units=imperial")
    Call<OpenWeatherMap>getWeatherWithCityName(@Query("q")String cityName);
}
