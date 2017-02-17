package com.famsa.eventadmin.service;

import java.util.Arrays;

import org.jboss.logging.Logger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.famsa.eventadmin.model.Application;
import com.famsa.eventadmin.model.Task;
import com.famsa.eventadmin.model.TaskSchedule;
import com.famsa.eventadmin.util.Enums;

@Service
public class EndpointService {

	private static final Logger LOGGER = Logger.getLogger(Application.class);

	/**
	 * Envia una peticion al endpoint configurado de una tarea
	 * <p>
	 * Por ahora solo funciona con las tipo REST
	 * 
	 * @param taskSchedule
	 */
	@Transactional
	public ResponseEntity<String> requestEndpoint(TaskSchedule taskSchedule) {
		LOGGER.debug("requestEndpoint -->");

		ResponseEntity<String> result = null;
		
		switch (Enums.ServiceType.values()[(int) taskSchedule.getTask().getServiceType().getId()]) {
		case REST:
			result = executeRestTemplate(taskSchedule);
			break;
		default:
			break;
		}

		LOGGER.debug("requestEndpoint //>");
		return result;
	}

	/**
	 * Ejecuta una peticion REST al endpoint especificado.
	 * <p>
	 * Por ahora solo funciona con las solicitudes GET
	 * 
	 * @param taskSchedule
	 */
	@Transactional
	public ResponseEntity<String> executeRestTemplate(TaskSchedule taskSchedule) {
		LOGGER.debug("executeRestTemplate -->");

		Task task = taskSchedule.getTask();

		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

		HttpMethod method;
		ResponseEntity<String> result;

		switch (Enums.RequestType.values()[(int) task.getRequestType().getId()]) {
		case GET:
			method = HttpMethod.GET;
			break;
		case POST:
			method = HttpMethod.POST;
			break;
		case PUT:
			method = HttpMethod.PUT;
			break;
		case DELETE:
			method = HttpMethod.DELETE;
			break;
		default:
			method = HttpMethod.GET;
			break;
		}

		result = restTemplate.exchange(task.getEndpoint(), method, entity, String.class);

		LOGGER.debug("executeRestTemplate //>");
		return result;
	}
}
