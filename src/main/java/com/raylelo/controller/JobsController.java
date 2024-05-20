package com.raylelo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.raylelo.model.Jobs;
import com.raylelo.response.ServiceResponse;
import com.raylelo.service.JobsService;


@RestController
@RequestMapping("/jobs")
public class JobsController {
	
	@Autowired
	private JobsService service;
	
	@PostMapping("/addJob")
	public ServiceResponse addJobs(@RequestBody Jobs job) {
		System.out.println("Jobs: "+ job.getJobName());
		return service.addJobs(job);
	}

}
