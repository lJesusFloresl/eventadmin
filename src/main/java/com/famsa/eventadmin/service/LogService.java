package com.famsa.eventadmin.service;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.famsa.eventadmin.model.Log;
import com.famsa.eventadmin.repository.LogRepository;

@Service
public class LogService {

	@Autowired
	private LogRepository repository;

	private static final Logger LOGGER = Logger.getLogger(Log.class);

	@Transactional
	public Log create(Log entity) {
		LOGGER.debug("create -->");
		Log ent = repository.save(entity);
		LOGGER.debug("create //>");
		return ent;
	}

	@Transactional
	public Log update(Log entity) {
		LOGGER.debug("update -->");
		Log ent = repository.saveAndFlush(entity);
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
	public Log findByIdFetch(Long id) {
		LOGGER.debug("findByIdFetch -->");
		Log ent = repository.findOne(id);
		LOGGER.debug("findByIdFetch //>");
		return ent;
	}

	@Transactional(readOnly = true)
	public List<Log> findAllFetch() {
		LOGGER.debug("findAllFetch -->");
		List<Log> list = repository.findAll();
		LOGGER.debug("findAllFetch //>");
		return list;
	}

}
