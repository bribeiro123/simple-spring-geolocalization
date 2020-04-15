package com.localization.maps.geolocalization.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Localization {

	public String formattedAddress;
	public int averageWaitingTime;
	public int maxVisitors;
	public int current_visitors;
	
	public Geometry geometry;
}
