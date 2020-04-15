package com.localization.maps.geolocalization.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.localization.maps.geolocalization.model.Localization;
import com.localization.maps.geolocalization.service.GeolocalizationService;

@RestController
@RequestMapping("/api")
public class GeolocalizationController {
	
	@Autowired
	private GeolocalizationService geolocalizationService;

	@RequestMapping(method = RequestMethod.GET, value = "/getlocalization")
    @ResponseBody
    public List<Localization> getLocalization(String address){
		return Optional.ofNullable(geolocalizationService.getGeoLocalzation(address)).orElse(new ArrayList<Localization>());
	}
	
}
