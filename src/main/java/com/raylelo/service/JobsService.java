package com.raylelo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raylelo.model.Jobs;
import com.raylelo.repository.JobsRepository;
import com.raylelo.response.ServiceResponse;

@Service
public class JobsService {
	
	@Autowired
	private JobsRepository jobsRepository;
	
	
	public ServiceResponse addJobs(Jobs job) {
		ServiceResponse serviceResponse = ServiceResponse.prepare();
		try {
			Jobs saveJob = jobsRepository.save(job);
			serviceResponse = new ServiceResponse(null, saveJob, null, true);
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return serviceResponse;
				
	} 
	
	public ServiceResponse getJobs() {
		ServiceResponse serviceResponse = ServiceResponse.prepare();
		try {
			List<Jobs> jobs = jobsRepository.findAll();
			serviceResponse = new ServiceResponse(null, jobs, null, true);
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return serviceResponse;
	}
	
	public ServiceResponse getJobDataById(Long jobId) {
		ServiceResponse serviceResponse = ServiceResponse.prepare();
		try {
			Jobs jobData = jobsRepository.findByJobId(jobId);
			serviceResponse = new ServiceResponse(null, jobData, null, true);
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return serviceResponse;
	}

}
