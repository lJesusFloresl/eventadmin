package com.famsa.eventadmin.service;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.famsa.eventadmin.model.LogTask;
import com.famsa.eventadmin.repository.LogTaskRepository;

@Service
public class LogTaskService {

	@Autowired
	private LogTaskRepository repository;

	private static final Logger LOGGER = Logger.getLogger(LogTask.class);

	@Transactional
	public LogTask create(LogTask entity) {
		LOGGER.debug("create -->");
		LogTask ent = repository.save(entity);
		LOGGER.debug("create //>");
		return ent;
	}

	@Transactional
	public LogTask update(LogTask entity) {
		LOGGER.debug("update -->");
		LogTask ent = repository.saveAndFlush(entity);
		LOGGER.debug("update //>");
		return ent;
	}
	
	@Transactional
	public void delete(Long id) {
		LOGGER.debug("delete -->");
		repository.delete(id);
		LOGGER.debug("delete //>");
	}

	@Transactional(readOnly = true)
	public LogTask findByIdFetch(Long id) {
		LOGGER.debug("findByIdFetch -->");
		LogTask ent = repository.findByIdFetch(id);
		LOGGER.debug("findByIdFetch //>");
		return ent;
	}

	@Transactional(readOnly = true)
	public List<LogTask> findAllFetch() {
		LOGGER.debug("findAllFetch -->");
		List<LogTask> list = repository.findAllFetch();
		LOGGER.debug("findAllFetch //>");
		return list;
	}
	
	@Transactional(readOnly = true)
	public List<LogTask> findAllByTaskId(Integer id) {
		LOGGER.debug("findAllByTaskId -->");
		List<LogTask> list = repository.findAllByTaskId(id);
		LOGGER.debug("findAllByTaskId //>");
		return list;
	}
	
	@Transactional(readOnly = true)
	public List<LogTask> findAllByStatusExecutionId(Short id) {
		LOGGER.debug("findAllByStatusExecutionId -->");
		List<LogTask> list = repository.findAllByStatusExecutionId(id);
		LOGGER.debug("findAllByStatusExecutionId //>");
		return list;
	}

}
