package com.famsa.eventadmin.util;

import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.Seconds;

import com.famsa.eventadmin.model.Task;

public class DateTimeUtil {

	/**
	 * Calcula la sincronizacion del reloj al siguiente minuto
	 * 
	 * @return milisegundos
	 */
	@SuppressWarnings("deprecation")
	public static long getMilisecondsToNextMinute() {
		Date currentDate = new Date();
		Date nextDate = new Date(currentDate.getYear(), currentDate.getMonth(), currentDate.getDay(),
				currentDate.getHours(), currentDate.getMinutes() + 1, 0);
		DateTime dtInit = new DateTime(currentDate);
		DateTime dtEnd = new DateTime(nextDate);
		int seconds = (Seconds.secondsBetween(dtInit, dtEnd).getSeconds() % 60);
		return seconds * 1000;
	}

	/**
	 * Calcula la fecha de la siguiente ejecucion de una tarea, si la hay
	 * <p>
	 * Por ahora solo trabaja con el caso de frecuencia diaria
	 * 
	 * @param task
	 * @return Fecha y hora ejecucion siguiente
	 */
	@SuppressWarnings("deprecation")
	public static Date getNextDateTimeExecution(Task task) {
		
		// Obtiene la fecha y hora actuales
		Date currentDate = new Date();
		DateTime dateTime = new DateTime(currentDate);

		// Si la tarea esta inactiva devuelve nulo
		if (task.getStatusTask().getName().equals("Inactivo")) {
			return null;
		}

		// Si la fecha de inicio de la tarea no existe o es posterior a la
		// actual devuelve nulo
		else if (task.getDateStart() == null && task.getDateStart().after(currentDate)) {
			return null;
		}

		// Si la fecha final de la tarea si existe y es anterior a la acutal
		// devuelve nulo
		else if (task.getDateEnd() != null && task.getDateEnd().before(currentDate)) {
			return null;
		}

		// Empiezan las operaciones
		else {

			Boolean su = task.getSunday() != null ? task.getSunday() : false;
			Boolean mo = task.getMonday() != null ? task.getMonday() : false;
			Boolean tu = task.getTuesday() != null ? task.getTuesday() : false;
			Boolean we = task.getWednesday() != null ? task.getWednesday() : false;
			Boolean th = task.getThursday() != null ? task.getThursday() : false;
			Boolean fr = task.getFriday() != null ? task.getFriday() : false;
			Boolean sa = task.getSaturday() != null ? task.getSaturday() : false;

			// Si no esta seleccionado ningun dia devuelve nulo
			if (!su && !mo && !tu && !we && !th && !fr && !sa) {
				return null;
			}

			else {
				Boolean validDate = false;

				// Obtiene la hora de ejecucion
				Date taskHour = task.getDateHourExecution();
				
				// Si la hora de ejeucion esta nula devuelve nulo
				if (taskHour == null) {
					return null;
				}
				
				// A la fecha actual se le setea la hora de ejecucion
				Date nextDate = new Date(currentDate.getYear(), currentDate.getMonth(), dateTime.getDayOfMonth(),
						taskHour.getHours(), taskHour.getMinutes(), taskHour.getSeconds());
				
				// Lo pasamos al Joda para mejor manejo
				DateTime dateExecution = new DateTime(nextDate);

				do {
					// Obtiene el dia de la semana de la fecha actual y lo compara con el respectivo
					// dia de la tarea
					Date dayDate = dateExecution.toDate();

					switch (Enums.daysOfWeek.values()[dayDate.getDay()]) {
					case LUNES:
						validDate = mo;
						break;
					case MARTES:
						validDate = tu;
						break;
					case MIERCOLES:
						validDate = we;
						break;
					case JUEVES:
						validDate = th;
						break;
					case VIERNES:
						validDate = fr;
						break;
					case SABADO:
						validDate = sa;
						break;
					case DOMINGO:
						validDate = su;
						break;
					default:
						break;
					}

					// Si no es una fecha valida, le suma un dia a la fecha de
					// ejecucion
					if (dayDate.before(currentDate)) {
						validDate = false;
					}
					
					if (!validDate) {
						dateExecution = dateExecution.plusDays(1);
					}
				} while (!validDate);

				return dateExecution.toDate();
			}
		}
	}
}
