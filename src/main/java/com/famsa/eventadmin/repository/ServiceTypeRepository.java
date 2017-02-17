package com.famsa.eventadmin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.famsa.eventadmin.model.ServiceType;

public interface ServiceTypeRepository extends JpaRepository<ServiceType, Short> {

}
