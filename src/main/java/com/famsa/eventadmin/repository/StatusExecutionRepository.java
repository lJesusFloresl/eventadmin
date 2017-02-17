package com.famsa.eventadmin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.famsa.eventadmin.model.StatusExecution;

public interface StatusExecutionRepository extends JpaRepository<StatusExecution, Short> {

}
