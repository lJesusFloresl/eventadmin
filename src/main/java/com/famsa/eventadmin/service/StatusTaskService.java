package com.famsa.eventadmin.service;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.famsa.eventadmin.model.StatusTask;
import com.famsa.eventadmin.repository.StatusTaskRepository;

@Service
public class StatusTaskService {

	@Autowired
	private StatusTaskRepository repository;

	private static final Logger LOGGER = Logger.getLogger(StatusTask.class);

	@Transactional
	public StatusTask create(StatusTask entity) {
		LOGGER.debug("create -->");
		StatusTask ent = repository.save(entity);
		LOGGER.debug("create //>");
		return ent;
	}

	@Transactional
	public StatusTask update(StatusTask entity) {
		LOGGER.debug("update -->");
		StatusTask ent = repository.saveAndFlush(entity);
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
	public StatusTask findByIdFetch(Short id) {
		LOGGER.debug("findByIdFetch -->");
		StatusTask ent = repository.findOne(id);
		LOGGER.debug("findByIdFetch //>");
		return ent;
	}

	@Transactional(readOnly = true)
	public List<StatusTask> findAllFetch() {
		LOGGER.debug("findAllFetch -->");
		List<StatusTask> list = repository.findAll();
		LOGGER.debug("findAllFetch //>");
		return list;
	}

}
