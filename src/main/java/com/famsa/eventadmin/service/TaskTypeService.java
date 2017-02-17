package com.famsa.eventadmin.service;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.famsa.eventadmin.model.TaskType;
import com.famsa.eventadmin.repository.TaskTypeRepository;

@Service
public class TaskTypeService {

	@Autowired
	private TaskTypeRepository repository;

	private static final Logger LOGGER = Logger.getLogger(TaskType.class);

	@Transactional
	public TaskType create(TaskType entity) {
		LOGGER.debug("create -->");
		TaskType ent = repository.save(entity);
		LOGGER.debug("create //>");
		return ent;
	}

	@Transactional
	public TaskType update(TaskType entity) {
		LOGGER.debug("update -->");
		TaskType ent = repository.saveAndFlush(entity);
		LOGGER.debug("update //>");
		return ent;
	}
	
	@Transactional
	public void delete(Short id) {
		LOGGER.debug("delete -->");
		repository.delete(id);
		LOGGER.debug("delete //>");
	}

	@Transactional(readOnly = true)
	public TaskType findByIdFetch(Short id) {
		LOGGER.debug("findByIdFetch -->");
		TaskType ent = repository.findOne(id);
		LOGGER.debug("findByIdFetch //>");
		return ent;
	}

	@Transactional(readOnly = true)
	public List<TaskType> findAllFetch() {
		LOGGER.debug("findAllFetch -->");
		List<TaskType> list = repository.findAll();
		LOGGER.debug("findAllFetch //>");
		return list;
	}

}
