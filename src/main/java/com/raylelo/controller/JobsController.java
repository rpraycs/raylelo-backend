package com.raylelo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.raylelo.model.Jobs;
import com.raylelo.response.ServiceResponse;
import com.raylelo.service.JobsService;


@RestController
@RequestMapping("/jobs")
@CrossOrigin(origins = "http://localhost:4200")
public class JobsController {
	
	@Autowired
	private JobsService service;
	
	@PostMapping("/addJob")
	public ServiceResponse addJobs(@RequestBody Jobs job) {
		//System.out.println("categoryId: "+ job.getCategoryId());
		return service.addJobs(job);
	}
	
	@GetMapping("/getJobs")
	public ServiceResponse getJobs() {
		return service.getJobs();
	}
	
	@GetMapping("/getJobs/{jobId}")
	public ServiceResponse getJobDataById(@PathVariable Long jobId) {
		return service.getJobDataById(jobId);
	}
	
	@GetMapping("/latestJobs/{tileType}")
	public ServiceResponse getLatestJobs(@PathVariable String tileType) {
		return service.getLatestJobs(tileType);
	}

}
