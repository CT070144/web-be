package com.kma.models;

import java.util.List;

public class errorResponseDTO {
	private String error;
	private List<String> details;
	
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public List<String> getDetails() {
		return details;
	}
	public void setDetails(List<String> details) {
		this.details = details;
	}
	
	
}
