package com.amindu.weather.weatherapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/weather")
@CrossOrigin(origins = "*")
public class WeatherController {

    @GetMapping("/{city}")
    public WeatherResponse getWeather(@PathVariable String city){

        return new WeatherResponse(city, "Sunny", 30.0);
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
