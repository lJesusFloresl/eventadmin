package com.famsa.eventadmin.service;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.famsa.eventadmin.model.RequestType;
import com.famsa.eventadmin.repository.RequestTypeRepository;

@Service
public class RequestTypeService {

	@Autowired
	private RequestTypeRepository repository;

	private static final Logger LOGGER = Logger.getLogger(RequestType.class);

	@Transactional
	public RequestType create(RequestType entity) {
		LOGGER.debug("create -->");
		RequestType ent = repository.save(entity);
		LOGGER.debug("create //>");
		return ent;
	}

	@Transactional
	public RequestType update(RequestType entity) {
		LOGGER.debug("update -->");
		RequestType ent = repository.saveAndFlush(entity);
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
	public RequestType findByIdFetch(Short id) {
		LOGGER.debug("findByIdFetch -->");
		RequestType ent = repository.findOne(id);
		LOGGER.debug("findByIdFetch //>");
		return ent;
	}

	@Transactional(readOnly = true)
	public List<RequestType> findAllFetch() {
		LOGGER.debug("findAllFetch -->");
		List<RequestType> list = repository.findAll();
		LOGGER.debug("findAllFetch //>");
		return list;
	}

}
