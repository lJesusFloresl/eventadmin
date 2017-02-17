package com.famsa.eventadmin.util;

public class Enums {

	public enum statusExecution {
		NINGUNO,
		OK,
		ERROR,
		NO_INICIADO
	}
	
	public enum daysOfWeekJoda {
		NINGUNO,
		LUNES,
		MARTES,
		MIERCOLES,
		JUEVES,
		VIERNES,
		SABADO,
		DOMINGO
	}
	
	public enum daysOfWeek {
		DOMINGO,
		LUNES,
		MARTES,
		MIERCOLES,
		JUEVES,
		VIERNES,
		SABADO
	}
	
	public enum ServiceType {
		NINGUNO,
		REST,
		SOAP
	}
	
	public enum RequestType {
		NINGUNO,
		GET,
		POST,
		PUT,
		DELETE
	}
}
