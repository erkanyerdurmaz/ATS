package com.example.appCandidate.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="candidate")
public class Candidate {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer id;

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

@Column(name = "candidate_full_name" ,nullable = false,length = 60)
 private String candidateFullName;

@Column(name = "job_role",nullable = false,length = 60)
private String jobRole;

@Column(name = "email",nullable = false,unique = true, length = 45)
private String email;

@Column(name = "location",nullable = false,length = 60)
private String location;


@Column(name = "candidate_statu",nullable = false,length = 20)
@Enumerated(EnumType.STRING)

private CandidateStatu candidateStatu;

	
}
