package com.famsa.eventadmin.timer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.famsa.eventadmin.service.JobService;

@Component("RunMeTask")
@Service
public class RunMeTask {
	
	@Autowired
	private JobService jobService;
	
	@Transactional
	public void execute() {
		jobService.checkScheduler();
	}
}
