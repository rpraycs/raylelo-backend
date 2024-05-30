package com.raylelo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.raylelo.model.Jobs;

public interface JobsRepository extends JpaRepository<Jobs, Long>{
	
	Jobs findByJobId(Long jobId);
	
	@Query("SELECT new Jobs(jobId, title, lastDateApply) FROM Jobs where status='ACTIVE'and tileType=:tileType")
	List<Jobs> getLatestJobs(@Param("tileType") String tileType);

}
