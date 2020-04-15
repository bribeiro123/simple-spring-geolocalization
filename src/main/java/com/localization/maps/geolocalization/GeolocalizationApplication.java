package com.localization.maps.geolocalization;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class GeolocalizationApplication {

	public static void main(String[] args) {
		SpringApplication.run(GeolocalizationApplication.class, args);
	}

}
