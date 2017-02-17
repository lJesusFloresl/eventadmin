package com.famsa.eventadmin.service;

import java.util.Date;
import java.util.List;

import org.jboss.logging.Logger;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.famsa.eventadmin.model.FrequencyType;
import com.famsa.eventadmin.model.RequestType;
import com.famsa.eventadmin.model.ServiceType;
import com.famsa.eventadmin.model.StatusExecution;
import com.famsa.eventadmin.model.StatusTask;
import com.famsa.eventadmin.model.Task;
import com.famsa.eventadmin.repository.TaskRepository;
import com.famsa.eventadmin.util.DateTimeParser;
import com.famsa.eventadmin.util.DateTimeUtil;
import com.famsa.eventadmin.util.Enums;
import com.famsa.eventadmin.model.TaskSchedule;
import com.famsa.eventadmin.model.TaskType;

@Service
public class TaskService {

	@Autowired
	private TaskRepository repository;

	@Autowired
	private TaskScheduleService taskScheduleService;

	private static final Logger LOGGER = Logger.getLogger(Task.class);

	@Transactional
	public Task create(Task entity) {
		LOGGER.debug("create -->");
		Task ent = repository.save(entity);
		LOGGER.debug("create //>");
		return ent;
	}

	@Transactional
	public Task update(Task entity) {
		LOGGER.debug("update -->");
		Task ent = repository.saveAndFlush(entity);
		LOGGER.debug("update //>");
		return ent;
	}

	@Transactional
	public void delete(Integer id) {
		LOGGER.debug("delete -->");
		repository.delete(id);
		LOGGER.debug("delete //>");
	}

	@Transactional(readOnly = true)
	public Task findByIdFetch(Integer id) {
		LOGGER.debug("findByIdFetch -->");
		Task ent = repository.findByIdFetch(id);
		LOGGER.debug("findByIdFetch //>");
		return ent;
	}

	@Transactional(readOnly = true)
	public List<Task> findAllFetch() {
		LOGGER.debug("findAllFetch -->");
		List<Task> list = repository.findAllFetch();
		LOGGER.debug("findAllFetch //>");
		return list;
	}

	@Transactional(readOnly = true)
	public List<Task> findAllByFrequencyTypeId(Short id) {
		LOGGER.debug("findAllByFrequencyTypeId -->");
		List<Task> list = repository.findAllByFrequencyTypeId(id);
		LOGGER.debug("findAllByFrequencyTypeId //>");
		return list;
	}

	@Transactional(readOnly = true)
	public List<Task> findAllByRequestTypeId(Short id) {
		LOGGER.debug("findAllByRequestTypeId -->");
		List<Task> list = repository.findAllByRequestTypeId(id);
		LOGGER.debug("findAllByRequestTypeId //>");
		return list;
	}

	@Transactional(readOnly = true)
	public List<Task> findAllByServiceTypeId(Short id) {
		LOGGER.debug("findAllByServiceTypeId -->");
		List<Task> list = repository.findAllByServiceTypeId(id);
		LOGGER.debug("findAllByServiceTypeId //>");
		return list;
	}

	@Transactional(readOnly = true)
	public List<Task> findAllByStatusTaskId(Short id) {
		LOGGER.debug("findAllByStatusTaskId -->");
		List<Task> list = repository.findAllByStatusTaskId(id);
		LOGGER.debug("findAllByStatusTaskId //>");
		return list;
	}

	@Transactional(readOnly = true)
	public List<Task> findAllByTaskTypeId(Short id) {
		LOGGER.debug("findAllByTaskTypeId -->");
		List<Task> list = repository.findAllByTaskTypeId(id);
		LOGGER.debug("findAllByTaskTypeId //>");
		return list;
	}

	/**
	 * Crea una tarea y luego su siguiente hora de ejecucion
	 * 
	 * @param entity
	 * @return
	 */
	@Transactional
	public Task createTaskAndSchedule(Task entity) {
		LOGGER.debug("createTaskAndSchedule -->");

		// Creamos la tarea
		entity.setDateCreated(new Date());
		entity.setDateLastChange(new Date());
		Task task = this.create(entity);

		// Asigna el horario de siguiente ejecucion
		TaskSchedule taskSchedule = new TaskSchedule();
		taskSchedule.setId(0);
		taskSchedule.setTask(task);
		taskSchedule.setStatusExecution(new StatusExecution((short) Enums.statusExecution.OK.ordinal(), "Ok"));
		taskSchedule.setDateTimeExecution(DateTimeUtil.getNextDateTimeExecution(task));
		TaskSchedule taskScheduleEntity = taskScheduleService.create(taskSchedule);

		System.out.println("La siguiente fecha de ejecucion de la tarea: " + task.getName() + " es: "
				+ DateTimeParser.toFullDateTimeFormatString(taskScheduleEntity.getDateTimeExecution()));

		LOGGER.debug("createTaskAndSchedule //>");
		return task;
	}

	/**
	 * Metodo utilizado para llenar una tarea de ejemplo
	 * 
	 * @return Tarea dummy
	 */
	@SuppressWarnings("deprecation")
	@Transactional
	public Task populateDummyTask() {
		DateTime startDate = new DateTime(new Date());
		DateTime endDate = startDate.plusMonths(3);
		Date hourExecution = new Date(startDate.getYear(), startDate.getMonthOfYear(), startDate.getDayOfMonth(), 13,
				30, 0);

		Task task = new Task();
		task.setId(0);
		task.setName("Tarea Dummy");
		task.setEndpoint("http://localhost:8090/eventadmin/api/v1/servicetype");
		task.setSunday(false);
		task.setMonday(false);
		task.setTuesday(true);
		task.setWednesday(false);
		task.setThursday(false);
		task.setFriday(true);
		task.setSaturday(false);
		task.setDateStart(startDate.toDate());
		task.setDateEnd(endDate.toDate());
		task.setDateHourExecution(hourExecution);
		task.setFrequencyType(new FrequencyType((short)1, "Por dia"));
		task.setServiceType(new ServiceType((short)1, ""));
		task.setServiceType(new ServiceType((short)1, ""));
		task.setRequestType(new RequestType((short)1, ""));
		task.setStatusTask(new StatusTask((short)1, "Activo"));
		task.setTaskType(new TaskType((short)1, ""));

		return this.createTaskAndSchedule(task);
	}
}
