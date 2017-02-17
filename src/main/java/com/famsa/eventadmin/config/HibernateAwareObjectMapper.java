package com.famsa.eventadmin.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.hibernate4.Hibernate4Module;

public class HibernateAwareObjectMapper extends ObjectMapper {
	private static final long serialVersionUID = -623771389004380378L;

	public HibernateAwareObjectMapper() {

		Hibernate4Module module = new Hibernate4Module();		
		module.disable(Hibernate4Module.Feature.USE_TRANSIENT_ANNOTATION);
		module.disable(Hibernate4Module.Feature.SERIALIZE_IDENTIFIER_FOR_LAZY_NOT_LOADED_OBJECTS);
		registerModule(module);
	}
}