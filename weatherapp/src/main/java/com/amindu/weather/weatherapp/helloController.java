package com.amindu.weather.weatherapp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class helloController {

    @Value("${app.welcome}")
    private String val;

    @RequestMapping("/hello")
    public String hello() {
        System.out.print(val);
        return "hello.html";
    }
}
