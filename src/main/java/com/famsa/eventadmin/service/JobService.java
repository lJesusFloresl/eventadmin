package com.famsa.eventadmin.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.famsa.eventadmin.model.StatusExecution;
import com.famsa.eventadmin.model.Task;
import com.famsa.eventadmin.model.TaskSchedule;
import com.famsa.eventadmin.service.EndpointService;
import com.famsa.eventadmin.service.TaskScheduleService;
import com.famsa.eventadmin.util.DateTimeUtil;
import com.famsa.eventadmin.util.Enums;
import com.famsa.eventadmin.util.MessageProcessor;
import com.famsa.eventadmin.util.StringMessages;

@Service
public class JobService {
	
	@Autowired
	private TaskScheduleService taskScheduleService;
	
	@Autowired
	private EndpointService endpointService;
	
	@Transactional
	public void checkScheduler() {
		MessageProcessor.printMessage(StringMessages.INFO_TYPE, StringMessages.TASK_MANAGER_CHECK_TASK);
		List<TaskSchedule> tasks = taskScheduleService.findAllExecutableByDates(new Date());
		this.executeTaskList(tasks);
	}

	@Transactional
	@Async
	private void executeTaskList(List<TaskSchedule> tasks) {
		MessageProcessor.printMessage(StringMessages.INFO_TYPE, StringMessages.TASK_MANAGER_TASKS_FOUND + tasks.size());
		for (TaskSchedule task : tasks) {
			try {
				this.executeTask(task);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Transactional
	private void executeTask(TaskSchedule taskSchedule) throws InterruptedException {
		Task task = taskSchedule.getTask();
		String taskString = String.format(StringMessages.TASK_ENDPOINT, task.getEndpoint(), task.getServiceType().getName(), task.getRequestType().getName());
		MessageProcessor.printMessage(StringMessages.INFO_TYPE, StringMessages.TASK_MANAGER_TASKS_EXECUTE + task.getName());
		MessageProcessor.printMessage(StringMessages.INFO_TYPE, taskString);
		ResponseEntity<String> result = endpointService.requestEndpoint(taskSchedule);
		this.updateStatusTask(taskSchedule, result);
	}
	
	@Transactional
	private void updateStatusTask(TaskSchedule taskSchedule, ResponseEntity<String> resultEndpoint) {
		MessageProcessor.printMessage(StringMessages.INFO_TYPE, resultEndpoint);
		if (resultEndpoint.getStatusCode() == HttpStatus.OK) {
			taskSchedule.setStatusExecution(new StatusExecution((short)Enums.statusExecution.OK.ordinal(), ""));
			taskScheduleService.update(taskSchedule);
			this.assignTaskSchedule(taskSchedule.getTask());
			MessageProcessor.printMessage(StringMessages.INFO_TYPE, StringMessages.TASK_SUCCESS);
		} else {
			taskSchedule.setStatusExecution(new StatusExecution((short)Enums.statusExecution.ERROR.ordinal(), ""));
			taskScheduleService.update(taskSchedule);
			this.assignTaskSchedule(taskSchedule.getTask());
			MessageProcessor.printMessage(StringMessages.ERROR_TYPE, StringMessages.TASK_ERROR);
		}
	}
	
	@Transactional
	private void assignTaskSchedule(Task task) {
		TaskSchedule taskSchedule = new TaskSchedule();
		taskSchedule.setId(0);
		taskSchedule.setTask(task);
		taskSchedule.setStatusExecution(new StatusExecution((short) Enums.statusExecution.NO_INICIADO.ordinal(), ""));
		taskSchedule.setDateTimeExecution(DateTimeUtil.getNextDateTimeExecution(task));
		taskScheduleService.create(taskSchedule);
	}
}
