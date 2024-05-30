package com.raylelo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.raylelo.model.Jobs;

public interface JobsRepository extends JpaRepository<Jobs, Long>{
	
	Jobs findByJobId(Long jobId);
	
	@Query("SELECT new Jobs(jobId, title, lastDateApply, category) FROM Jobs where status='ACTIVE'and category.categoryId in (1,2)")
	List<Jobs> getLatestJobs();
	
	@Query("SELECT new Jobs(jobId, title, lastDateApply, category) FROM Jobs where status='ACTIVE'and category.categoryId in (4)")
	List<Jobs> getResults();
	
	@Query("SELECT new Jobs(jobId, title, lastDateApply, category) FROM Jobs where status='ACTIVE'and category.categoryId in (3)")
	List<Jobs> getAdmitCards();

}
