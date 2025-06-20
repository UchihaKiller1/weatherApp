package com.amindu.weather.weatherapp;

import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/weather")
@CrossOrigin(origins = "*")
public class WeatherController {

    private final String API_KEY ="0b06c3ae86914ddbf425f37153203472";

    @GetMapping("/{city}")
    public WeatherResponse getWeather(@PathVariable String city){

        try {
            String url = "https://api.openweathermap.org/data/2.5/weather?q=" + city +
                    "&appid=" + API_KEY + "&units=metric";
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

            JSONObject json = new JSONObject(response.getBody());

            String weather = json.getJSONArray("weather").getJSONObject(0).getString("main");
            double temperature = json.getJSONObject("main").getDouble("temp");

            return new WeatherResponse(city, weather, temperature);
        } catch (Exception e) {
            // Log error and return some default or error message
            System.err.println("Error fetching weather: " + e.getMessage());
            return new WeatherResponse(city, "Not Found", 0);
        }

    }

    public static class WeatherResponse {

        public String city;
        public String condition;
        public double temperature;

        public WeatherResponse(String city, String condition, double temperature) {
            this.city = city;
            this.condition = condition;
            this.temperature = temperature;
        }

    }
}
