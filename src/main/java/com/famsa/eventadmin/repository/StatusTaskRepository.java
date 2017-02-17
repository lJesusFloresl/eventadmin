package com.famsa.eventadmin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.famsa.eventadmin.model.StatusTask;

public interface StatusTaskRepository extends JpaRepository<StatusTask, Short> {

}
