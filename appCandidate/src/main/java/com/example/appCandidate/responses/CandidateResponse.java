package com.example.appCandidate.responses;

import com.example.appCandidate.entities.Candidate;
import com.example.appCandidate.entities.CandidateStatu;

public class CandidateResponse {
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCandidateFullName() {
		return candidateFullName;
	}
	public void setCandidateFullName(String candidateFullName) {
		this.candidateFullName = candidateFullName;
	}
	public String getJobRole() {
		return jobRole;
	}
	public void setJobRole(String jobRole) {
		this.jobRole = jobRole;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public CandidateStatu getCandidateStatu() {
		return candidateStatu;
	}
	public void setCandidateStatu(CandidateStatu candidateStatu) {
		this.candidateStatu = candidateStatu;
	}
	private  Integer id;
	private String candidateFullName;
	private String jobRole;
	private String email;
	private String location;
	private CandidateStatu candidateStatu;
	
	public CandidateResponse (Candidate entity) {
		this.id = entity.getId();
		this.candidateFullName= entity.getCandidateFullName();
		this.email = entity.getEmail();
		this.jobRole = entity.getJobRole();
		this.location = entity.getLocation();
		this.candidateStatu= entity.getCandidateStatu();	
		
	}

}
