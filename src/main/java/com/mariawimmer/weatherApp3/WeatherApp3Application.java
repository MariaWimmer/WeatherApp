package com.mariawimmer.weatherApp3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class WeatherApp3Application {

	public static void main(String[] args) {
		SpringApplication.run(WeatherApp3Application.class, args);
	}

}
