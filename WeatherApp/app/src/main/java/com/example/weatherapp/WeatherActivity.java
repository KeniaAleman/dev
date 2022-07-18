package com.example.weatherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WeatherActivity extends AppCompatActivity {

    private TextView cityWeather, temperatureWeather, weatherConditionWeather, humidityWeather, maxTemperatureWeather, minTemperatureWeather, pressureWeather, windWeather;
    private ImageView imageViewWeather;
    private FloatingActionButton floatingActionButtonWeather;
    private Button search;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        cityWeather = findViewById(R.id.textViewCityWeather);
        temperatureWeather = findViewById(R.id.textViewTempWeather);
        weatherConditionWeather = findViewById(R.id.textViewWeatherConditionWeather);
        humidityWeather = findViewById(R.id.textViewHumidityWeather);
        maxTemperatureWeather = findViewById(R.id.textViewMaxTempWeather);
        minTemperatureWeather = findViewById(R.id.textViewMinTempWeather);
        pressureWeather = findViewById(R.id.textViewPressureWeather);
        windWeather = findViewById(R.id.textViewWindWeather);
        imageViewWeather = findViewById(R.id.imageViewWeather);
        search = findViewById(R.id.search);
        editText = findViewById(R.id.editTextCityName);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String cityName = editText.getText().toString();

                getWeatherDataWeather(cityName);
                editText.setText("");
            }

        });
    }

    public void getWeatherDataWeather(String cityName) {
        WeatherAPI weatherAPI = RetrofitWeather.getClient().create(WeatherAPI.class);
        Call<OpenWeatherMap> call = weatherAPI.getWeatherWithCityName(cityName);
        call.enqueue(new Callback<OpenWeatherMap>() {
            @Override
            public void onResponse(Call<OpenWeatherMap> call, Response<OpenWeatherMap> response) {

                if (response.isSuccessful()) {
                    cityWeather.setText(response.body().getName() + " , " + response.body().getSys().getCountry());
                    temperatureWeather.setText(response.body().getMain().getTemp() + " °F");
                    weatherConditionWeather.setText(response.body().getWeather().get(0).getDescription());
                    humidityWeather.setText(response.body().getMain().getHumidity() + " %");
                    maxTemperatureWeather.setText(response.body().getMain().getTempMax() + "");
                    minTemperatureWeather.setText(response.body().getMain().getTempMin() + "");
                    pressureWeather.setText(response.body().getMain().getPressure() + "");
                    windWeather.setText(response.body().getWind().getSpeed() + "");

                    String iconCode = response.body().getWeather().get(0).getIcon();
                    Picasso.get().load("https://openweathermap.org/img/wn/" + iconCode + "d@2x.png")
                            .placeholder(R.drawable.ic_launcher_background)
                            .into(imageViewWeather);

                } else {
                    Toast.makeText(WeatherActivity.this, "City not found, please try again.", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<OpenWeatherMap> call, Throwable t) {

            }
        });
    }
}