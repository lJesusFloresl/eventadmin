package com.famsa.eventadmin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.famsa.eventadmin.model.TaskType;

public interface TaskTypeRepository extends JpaRepository<TaskType, Short> {

}
