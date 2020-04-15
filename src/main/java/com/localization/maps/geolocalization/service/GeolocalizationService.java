package com.localization.maps.geolocalization.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.localization.maps.geolocalization.model.Localization;
import com.localization.maps.geolocalization.model.LocalizationList;
import com.localization.maps.geolocalization.utils.DateUtils;

@Service
public class GeolocalizationService {

	private static final Logger log = LoggerFactory.getLogger(GeolocalizationService.class);

	@Value("${geolocalization.api.apikey}")
	private String apiKey;

	@Value("${geolocalization.api.uri}")
	private String geocondingURI;

	public List<Localization> getGeoLocalzation(String address) {
		RestTemplate restTemplate = new RestTemplate();
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(this.geocondingURI)
				.queryParam("query", address).queryParam("key", apiKey);
		log.info("Calling geocoding api with: " + builder.toUriString());
		LocalizationList response = restTemplate.getForObject(builder.toUriString(), LocalizationList.class);
		return addnewsLetters(response.getResults());
	}

	private List<Localization> addnewsLetters(List<Localization> results) {
		for (Localization localization : results) {
			localization.setAverageWaitingTime((int) (Math.random() * (60 - 1)) + 1);
			localization.setCurrent_visitors((int) Math.random() * (20 - 1) + 1);
			localization.setMaxVisitors((int) Math.random() * (30 - 1) + 1);

		}
		return results;
	}
}
