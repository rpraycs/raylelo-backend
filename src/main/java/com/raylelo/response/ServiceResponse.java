package com.raylelo.response;

import java.util.List;

import com.raylelo.model.Jobs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServiceResponse {

	private String msg;
	private Object data;
	private String error;
	private Boolean success;
	private List<Jobs> jobs;
	
	public ServiceResponse(String msg, List<Jobs> jobs, String error, Boolean success) {
		this.msg = msg;
		this.jobs = jobs;
		this.error = error;
		this.success = success;
	}
	
	public ServiceResponse (String msg, Object data, String error, Boolean success) {
		this.msg = msg;
		this.data = data;
		this.error = error;
		this.success = success;
	}
	
	public static ServiceResponse prepare() {
		return new ServiceResponse(null, null, null, false);
	}
	
	
}
