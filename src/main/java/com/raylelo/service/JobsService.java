package com.raylelo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raylelo.DTO.DashboardDto;
import com.raylelo.DTO.TileDto;
import com.raylelo.model.Category;
import com.raylelo.model.Jobs;
import com.raylelo.repository.CategoryRepository;
import com.raylelo.repository.JobsRepository;
import com.raylelo.response.ServiceResponse;

@Service
public class JobsService {

	@Autowired
	private JobsRepository jobsRepository;

	@Autowired
	private CategoryRepository catRepo;

	public ServiceResponse getHomeData() {
		ServiceResponse serviceResponse = ServiceResponse.prepare();
		try {
			List<Jobs> jobs = jobsRepository.getJobsByStatus();
			if (jobs != null && jobs.size() > 0) {
				List<Jobs> tilesData = jobsRepository.getActiveTiles();
				List<TileDto> tiles = tilesData.stream().map(it -> new TileDto(it.getTileName(), it.getTileType())).collect(Collectors.toList());
				List<Jobs> results = jobs.stream().filter(it-> it.getCategory().getCategoryId()== 4).collect(Collectors.toList());
				List<Jobs> admitCards = jobs.stream().filter(it-> it.getCategory().getCategoryId()== 3).collect(Collectors.toList());
				List<Jobs> latestJobs = jobs.stream().filter(it-> (it.getCategory().getCategoryId()== 1 || it.getCategory().getCategoryId()==2)).collect(Collectors.toList());
				DashboardDto dto = new DashboardDto();
				dto.setTiles(tiles);
				dto.setResults(results);
				dto.setAdmitCards(admitCards);
				dto.setLatestJobs(latestJobs);
				serviceResponse = new ServiceResponse(null, dto, null, true);
			}
			
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return serviceResponse;

	}

	public ServiceResponse addJobs(Jobs job) {
		ServiceResponse serviceResponse = ServiceResponse.prepare();
		try {
			if (job.getCategoryId() != null) {
				Category category = catRepo.findByCategoryId(job.getCategoryId());
				job.setCategory(category);
			}
			Jobs saveJob = jobsRepository.save(job);
			serviceResponse = new ServiceResponse(null, saveJob, null, true);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return serviceResponse;

	}

	public ServiceResponse getJobs() {
		ServiceResponse serviceResponse = ServiceResponse.prepare();
		try {
			List<Jobs> jobs = jobsRepository.findAll();
			serviceResponse = new ServiceResponse(null, jobs, null, true);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return serviceResponse;
	}

	public ServiceResponse getJobDataById(Long jobId) {
		ServiceResponse serviceResponse = ServiceResponse.prepare();
		try {
			Jobs jobData = jobsRepository.findByJobId(jobId);
			serviceResponse = new ServiceResponse(null, jobData, null, true);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return serviceResponse;
	}

	public ServiceResponse getLatestJobs() {
		ServiceResponse serviceResponse = ServiceResponse.prepare();
		try {
			List<Jobs> jobs = jobsRepository.getLatestJobs();
			serviceResponse = new ServiceResponse(null, jobs, null, true);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return serviceResponse;
	}

	public ServiceResponse getResults() {
		ServiceResponse serviceResponse = ServiceResponse.prepare();
		try {
			List<Jobs> jobs = jobsRepository.getResults();
			serviceResponse = new ServiceResponse(null, jobs, null, true);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return serviceResponse;
	}

	public ServiceResponse getAdmitCards() {
		ServiceResponse serviceResponse = ServiceResponse.prepare();
		try {
			List<Jobs> jobs = jobsRepository.getAdmitCards();
			serviceResponse = new ServiceResponse(null, jobs, null, true);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return serviceResponse;
	}
}
