package com.famsa.eventadmin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.famsa.eventadmin.model.TaskApplication;

public interface TaskApplicationRepository extends JpaRepository<TaskApplication, Integer> {
	
	@Query("select model from TaskApplication model "
			+ "join fetch model.task "
			+ "join fetch model.application ")
	public List<TaskApplication> findAllFetch();

	@Query("select model from TaskApplication model "
			+ "join fetch model.task "
			+ "join fetch model.application "
			+ "where model.id = :id")
	public TaskApplication findByIdFetch(@Param("id") Integer id);
	
	@Query("select model from TaskApplication model "
			+ "join fetch model.task "
			+ "join fetch model.application "
			+ "where model.task.id = :id")
	public List<TaskApplication> findAllByTaskId(@Param("id") Integer id);
	
	@Query("select model from TaskApplication model "
			+ "join fetch model.task "
			+ "join fetch model.application "
			+ "where model.application.id = :id")
	public List<TaskApplication> findAllByApplicationId(@Param("id") Integer id);
}
