package com.mariawimmer.weatherApp3.controller;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URL;
import java.util.Scanner;

@RestController
public class ControllerWeather {

    @RequestMapping("/weather/city/Vienna")
    @Cacheable("weather/city/Vienna")
    public String weatherInfo() throws Exception{
        Thread.sleep(5000);
        Scanner scanner = new Scanner(new URL("http://api.openweathermap.org/data/2.5/weather?q=vienna&APPID=bca79125c5f5bb4b8beda66a6ecf2d58").openStream());
        String weather = scanner.nextLine();
        scanner.close();
        return weather;
    }

    @RequestMapping("/clearCache")
    @CacheEvict("/weather/city/Vienna")
    public String clearCache() {
        return "Cache is cleared successfully";
    }

}
