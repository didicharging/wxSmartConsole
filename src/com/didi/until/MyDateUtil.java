package com.didi.until;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class MyDateUtil {
	
	public static final String DEFAULT_DATEFORMAT = "yyyy-MM-dd";
	
	public static Date parseDate(String dateStr, String format){
		if((dateStr != null) && (dateStr.length() > 0)){
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			try{
				Date result = sdf.parse(dateStr);
				return result;
			}catch(Exception e){
				return null;
			}
		}else{
			return null;
		}
	}
	
	public static Date parseDate(String dateStr){
		String format = DEFAULT_DATEFORMAT;
		if((dateStr != null) && (dateStr.length() > 0)){
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			try{
				Date result = sdf.parse(dateStr);
				return result;
			}catch(Exception e){
				return null;
			}
		}else{
			return null;
		}
	}
	
	public static String format(Date date){
		if(date != null){
			SimpleDateFormat sdf = new SimpleDateFormat(DEFAULT_DATEFORMAT);
			try{
				String result = sdf.format(date);
				return result;
			}catch(Exception e){
				return null;
			}
		}else{
			return null;
		}
	}
	public static String format(Date date, String format){
		if(date != null){
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			try{
				String result = sdf.format(date);
				return result;
			}catch(Exception e){
				return null;
			}
		}else{
			return null;
		}
	}
	
	public static String getTimeStampInSeconds(Date date, TimeZone oldTimeZone, TimeZone newTimeZone){
		Long seconds = (date.getTime() - oldTimeZone.getRawOffset() + newTimeZone.getRawOffset())/1000;
		return seconds + "";
	}
	public static String getTimeStampInSecondsBeijing(Date date){
		return getTimeStampInSeconds(date, 
				TimeZone.getDefault(), 
				TimeZone.getTimeZone("Asia/Shanghai"));
	}
	
	public static int getWeekDay(Date date){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int weekday = calendar.get(Calendar.DAY_OF_WEEK) - 1;
		if(weekday <= 0){
			weekday = 7;
		}
		return weekday;
	}
	public static void main(String[] args){
		
		Date date = new Date();
//		System.out.println("timestamp in seconds: " 
//								+ getTimeStampInSeconds(date, 
//									TimeZone.getDefault(), 
//									TimeZone.getTimeZone("Asia/Shanghai")));
//		
//		System.out.println(TimeZone.getDefault());
//		TimeZone.setDefault(TimeZone.getTimeZone("GMT"));
//		System.out.println(TimeZone.getDefault());
//		
//		System.out.println("timestamp in seconds beijing: " 
//				+ getTimeStampInSecondsBeijing(date));
		date = parseDate("2017-02-20 00:00:00");
		System.out.println(getWeekDay(date));
		
	}

}
