package com.famsa.eventadmin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.famsa.eventadmin.model.Task;

public interface TaskRepository extends JpaRepository<Task, Integer> {
	
	@Query("select model from Task model "
			+ "join fetch model.frequencyType "
			+ "join fetch model.serviceType "
			+ "join fetch model.requestType "
			+ "join fetch model.statusTask "
			+ "join fetch model.taskType ")
	public List<Task> findAllFetch();
	
	@Query("select model from Task model "
			+ "join fetch model.frequencyType "
			+ "join fetch model.serviceType "
			+ "join fetch model.requestType "
			+ "join fetch model.statusTask "
			+ "join fetch model.taskType "
			+ "where model.id = :id")
	public Task findByIdFetch(@Param("id") Integer id);
	
	@Query("select model from Task model "
			+ "join fetch model.frequencyType "
			+ "join fetch model.serviceType "
			+ "join fetch model.requestType "
			+ "join fetch model.statusTask "
			+ "join fetch model.taskType "
			+ "where model.frequencyType.id = :id")
	public List<Task> findAllByFrequencyTypeId(@Param("id") Short id);
	
	@Query("select model from Task model "
			+ "join fetch model.frequencyType "
			+ "join fetch model.serviceType "
			+ "join fetch model.requestType "
			+ "join fetch model.statusTask "
			+ "join fetch model.taskType "
			+ "where model.serviceType.id = :id")
	public List<Task> findAllByServiceTypeId(@Param("id") Short id);
	
	@Query("select model from Task model "
			+ "join fetch model.frequencyType "
			+ "join fetch model.serviceType "
			+ "join fetch model.requestType "
			+ "join fetch model.statusTask "
			+ "join fetch model.taskType "
			+ "where model.requestType.id = :id")
	public List<Task> findAllByRequestTypeId(@Param("id") Short id);
	
	@Query("select model from Task model "
			+ "join fetch model.frequencyType "
			+ "join fetch model.serviceType "
			+ "join fetch model.requestType "
			+ "join fetch model.statusTask "
			+ "join fetch model.taskType "
			+ "where model.statusTask.id = :id")
	public List<Task> findAllByStatusTaskId(@Param("id") Short id);
	
	@Query("select model from Task model "
			+ "join fetch model.frequencyType "
			+ "join fetch model.serviceType "
			+ "join fetch model.requestType "
			+ "join fetch model.statusTask "
			+ "join fetch model.taskType "
			+ "where model.taskType.id = :id")
	public List<Task> findAllByTaskTypeId(@Param("id") Short id);

}
