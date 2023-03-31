package com.example.appCandidate.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.appCandidate.entities.Candidate;
import com.example.appCandidate.repositories.CandidateRepository;
import com.example.appCandidate.requests.CandidateCreateRequest;
import com.example.appCandidate.requests.CandidateUpdateRequest;

@Service
public class CandidateService {
	
	CandidateRepository candidateRepository;

	public CandidateService(CandidateRepository candidateRepository) {
		this.candidateRepository = candidateRepository;
	}
	
	public List<Candidate> getAllCandidates(){
		
		return candidateRepository.findAll();
	}
	
	public Candidate createOneCandidate(CandidateCreateRequest newCandidate) {
		
		Candidate entity = new Candidate();
		entity.setId(newCandidate.getId());
		entity.setCandidateFullName(newCandidate.getCandidateFullName());
		entity.setJobRole(newCandidate.getJobRole());
		entity.setEmail(newCandidate.getEmail());
		entity.setLocation(newCandidate.getLocation());
		entity.setCandidateStatu(newCandidate.getCandidateStatu());
		
		return candidateRepository.save(entity);	
		
	}
	
	public Candidate getOneCandidate(Integer candidateId) {
			
		return candidateRepository.findById(candidateId).orElse(null);	
			
	}
	
	public Candidate updateOneCandidate(Integer candidateId,CandidateUpdateRequest updateCandidate) {
		
		Optional<Candidate> candidate = candidateRepository.findById(candidateId);
		
		if(candidate.isPresent()) {
			Candidate foundCandidate = candidate.get();
			foundCandidate.setCandidateFullName(updateCandidate.getCandidateFullName());
			foundCandidate.setCandidateStatu(updateCandidate.getCandidateStatu());
			foundCandidate.setJobRole(updateCandidate.getJobRole());
			foundCandidate.setEmail(updateCandidate.getEmail());
			foundCandidate.setLocation(updateCandidate.getLocation());
			
			candidateRepository.save(foundCandidate);
			
			return foundCandidate;
			
		}else {
			return null;
		}
		
		
	}
	
	public void deleteOneCandidate(Integer candidateId) {
		
		candidateRepository.deleteById(candidateId);
		
	}
	
}
