package com.raylelo.response;

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
	
	public static ServiceResponse prepare() {
		return new ServiceResponse(null, null, null, false);
	}
	
}
