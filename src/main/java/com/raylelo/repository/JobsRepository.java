package com.raylelo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.raylelo.model.Jobs;

public interface JobsRepository extends JpaRepository<Jobs, Long>{

}
