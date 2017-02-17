package com.famsa.eventadmin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.famsa.eventadmin.model.LogTask;

public interface LogTaskRepository extends JpaRepository<LogTask, Long> {
	
	@Query("select model from LogTask model "
			+ "join fetch model.log "
			+ "join fetch model.task "
			+ "join fetch model.statusExecution ")
	public List<LogTask> findAllFetch();
	
	@Query("select model from LogTask model "
			+ "join fetch model.log "
			+ "join fetch model.task "
			+ "join fetch model.statusExecution "
			+ "where model.id = :id")
	public LogTask findByIdFetch(@Param("id") Long id);
	
	@Query("select model from LogTask model "
			+ "join fetch model.log "
			+ "join fetch model.task "
			+ "join fetch model.statusExecution "
			+ "where model.task.id = :id")
	public List<LogTask> findAllByTaskId(@Param("id") Integer id);
	
	@Query("select model from LogTask model "
			+ "join fetch model.task "
			+ "join fetch model.statusExecution "
			+ "where model.statusExecution.id = :id")
	public List<LogTask> findAllByStatusExecutionId(@Param("id") Short id);

}
