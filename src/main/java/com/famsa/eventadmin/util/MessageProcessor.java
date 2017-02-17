package com.famsa.eventadmin.util;

import java.util.Date;

import org.springframework.http.ResponseEntity;

public class MessageProcessor {

	public static void printMessage(String messageType, String action) {
		Date currentDate = new Date();
		System.out.println(
				messageType + ": [" + DateTimeParser.toFullDateTimeFormatString(currentDate) + "] - " + action);
	}
	
	public static void printMessage(String messageType, ResponseEntity<String> body) {
		Date currentDate = new Date();
		System.out.println(
				messageType + ": [" + DateTimeParser.toFullDateTimeFormatString(currentDate) + "] - " + body);
	}
}
