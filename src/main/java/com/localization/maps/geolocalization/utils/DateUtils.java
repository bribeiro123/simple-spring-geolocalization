package com.localization.maps.geolocalization.utils;

import java.math.BigInteger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DateUtils {

	private static final long ONE_MINUTE_IN_MILLIS=60000;//
	
	public static Date getAvarageTime() {
		List<Date> dates = Arrays.asList(new Date(), addMinutesMyDate());
		BigInteger total = BigInteger.ZERO;
		for (Date date : dates) {
			total = total.add(BigInteger.valueOf(date.getTime()));
		}
		BigInteger averageMillis = total.divide(BigInteger.valueOf(dates.size()));
		Date averageDate = new Date(averageMillis.longValue());
		return averageDate;
	}

	
	private static Date addMinutesMyDate() {
		Calendar date = Calendar.getInstance();
		long t= date.getTimeInMillis();
		Date afterAddingTenMins=new Date(t + (10 * ONE_MINUTE_IN_MILLIS));
		return afterAddingTenMins;
	}
	
	public static String convertDateToString(Date date) {
		Date newdate = date;
        DateFormat dateFormat = new SimpleDateFormat("hh:mm:ss"); 
        String strDate = dateFormat.format(newdate);  
        System.out.println("Converted String: " + strDate);  
        return strDate;
	}
}
