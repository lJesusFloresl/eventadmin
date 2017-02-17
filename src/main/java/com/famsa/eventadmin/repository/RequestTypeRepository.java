package com.famsa.eventadmin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.famsa.eventadmin.model.RequestType;

public interface RequestTypeRepository extends JpaRepository<RequestType, Short> {

}
