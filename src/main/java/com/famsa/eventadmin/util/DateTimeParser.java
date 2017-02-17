package com.famsa.eventadmin.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.joda.time.DateTime;

public class DateTimeParser {
	
	private static final SimpleDateFormat fullDateTimeFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	private static final SimpleDateFormat dateTimeFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	private static final SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
	private static final SimpleDateFormat fullTimeFormat = new SimpleDateFormat("HH:mm:ss");	
	
	public static String toFullDateTimeFormatString(Date date) {
		return fullDateTimeFormat.format(date);
	}
	
	public static String toFullDateTimeFormatString(DateTime date) {
		return fullDateTimeFormat.format(date);
	}
	
	public static String toDateTimeFormatString(Date date) {
		return dateTimeFormat.format(date);
	}
	
	public static String toDateTimeFormatString(DateTime date) {
		return dateTimeFormat.format(date);
	}
	
	public static String toDateFormatString(Date date) {
		return dateFormat.format(date);
	}
	
	public static String toDateFormatString(DateTime date) {
		return dateFormat.format(date);
	}
	
	public static String toTimeFormatString(Date date) {
		return timeFormat.format(date);
	}
	
	public static String toTimeFormatString(DateTime date) {
		return timeFormat.format(date);
	}
	
	public static String toFullTimeFormatString(Date date) {
		return fullTimeFormat.format(date);
	}
	
	public static String toFullTimeFormatString(DateTime date) {
		return fullTimeFormat.format(date);
	}
}
