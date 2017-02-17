package com.famsa.eventadmin.service;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.famsa.eventadmin.model.ServiceType;
import com.famsa.eventadmin.repository.ServiceTypeRepository;

@Service
public class ServiceTypeService {

	@Autowired
	private ServiceTypeRepository repository;

	private static final Logger LOGGER = Logger.getLogger(ServiceType.class);

	@Transactional
	public ServiceType create(ServiceType entity) {
		LOGGER.debug("create -->");
		ServiceType ent = repository.save(entity);
		LOGGER.debug("create //>");
		return ent;
	}

	@Transactional
	public ServiceType update(ServiceType entity) {
		LOGGER.debug("update -->");
		ServiceType ent = repository.saveAndFlush(entity);
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
	public ServiceType findByIdFetch(Short id) {
		LOGGER.debug("findByIdFetch -->");
		ServiceType ent = repository.findOne(id);
		LOGGER.debug("findByIdFetch //>");
		return ent;
	}

	@Transactional(readOnly = true)
	public List<ServiceType> findAllFetch() {
		LOGGER.debug("findAllFetch -->");
		List<ServiceType> list = repository.findAll();
		LOGGER.debug("findAllFetch //>");
		return list;
	}

}
