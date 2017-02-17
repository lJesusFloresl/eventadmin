package com.famsa.eventadmin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.famsa.eventadmin.model.Log;

public interface LogRepository extends JpaRepository<Log, Long> {

}
