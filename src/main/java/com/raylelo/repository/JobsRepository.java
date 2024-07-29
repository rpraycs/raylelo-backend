package com.raylelo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.raylelo.model.Jobs;

public interface JobsRepository extends JpaRepository<Jobs, Long>{
	
	Jobs findByJobId(Long jobId);
	
	@Query("SELECT new Jobs(jobId, title, lastDateApply, category) FROM Jobs where status='ACTIVE'and category.categoryId in (1,2) ORDER BY createdDate DESC")
	List<Jobs> getLatestJobs();
	
	@Query("SELECT new Jobs(jobId, title, lastDateApply, category) FROM Jobs where status='ACTIVE'and category.categoryId in (4) ORDER BY createdDate DESC")
	List<Jobs> getResults();
	
	@Query("SELECT new Jobs(jobId, title, lastDateApply, category) FROM Jobs where status='ACTIVE'and category.categoryId in (3) ORDER BY createdDate DESC")
	List<Jobs> getAdmitCards();
	
	@Query("SELECT j FROM Jobs j where j.status='ACTIVE' ORDER BY createdDate DESC")
	List<Jobs> getJobsByStatus();
	
	@Query("SELECT new Jobs(jobId, tileName, tileType) FROM Jobs WHERE status='ACTIVE' AND tileStatus='ACTIVE' ORDER BY createdDate DESC LIMIT 8")
	List<Jobs> getActiveTiles();

}  
