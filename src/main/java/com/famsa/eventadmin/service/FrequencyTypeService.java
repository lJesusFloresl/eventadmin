package com.famsa.eventadmin.service;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.famsa.eventadmin.model.FrequencyType;
import com.famsa.eventadmin.repository.FrequencyTypeRepository;

@Service
public class FrequencyTypeService {

	@Autowired
	private FrequencyTypeRepository repository;

	private static final Logger LOGGER = Logger.getLogger(FrequencyType.class);

	@Transactional
	public FrequencyType create(FrequencyType entity) {
		LOGGER.debug("create -->");
		FrequencyType ent = repository.save(entity);
		LOGGER.debug("create //>");
		return ent;
	}

	@Transactional
	public FrequencyType update(FrequencyType entity) {
		LOGGER.debug("update -->");
		FrequencyType ent = repository.saveAndFlush(entity);
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
	public FrequencyType findByIdFetch(Short id) {
		LOGGER.debug("findByIdFetch -->");
		FrequencyType ent = repository.findOne(id);
		LOGGER.debug("findByIdFetch //>");
		return ent;
	}

	@Transactional(readOnly = true)
	public List<FrequencyType> findAllFetch() {
		LOGGER.debug("findAllFetch -->");
		List<FrequencyType> list = repository.findAll();
		LOGGER.debug("findAllFetch //>");
		return list;
	}

}
