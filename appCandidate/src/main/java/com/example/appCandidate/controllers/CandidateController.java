package com.example.appCandidate.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.appCandidate.entities.Candidate;
import com.example.appCandidate.requests.CandidateCreateRequest;
import com.example.appCandidate.requests.CandidateUpdateRequest;
import com.example.appCandidate.responses.CandidateResponse;
import com.example.appCandidate.services.CandidateService;

@CrossOrigin("http://localhost:8082/")
@RestController
@RequestMapping("/candidates")
public class CandidateController {
	
	private CandidateService candidateService;

	public CandidateController(CandidateService candidateService) {
		this.candidateService = candidateService;
	}
	
	@GetMapping
	
	public ResponseEntity<List<CandidateResponse>> getAllCandidates(){
		
		List<CandidateResponse> allCandidates = candidateService.getAllCandidates().stream()
				.map(u->new CandidateResponse(u)).toList();
		return ResponseEntity.ok(allCandidates);
	}
	
	@PostMapping
	
	public ResponseEntity<Candidate> createOneCandidate(@RequestBody CandidateCreateRequest newCandidate) {
		
		return new ResponseEntity<Candidate>(candidateService.createOneCandidate(newCandidate),HttpStatus.CREATED);
	}
	
	@GetMapping("/{candidateId}")
	
	public ResponseEntity<Candidate> getOneCandidate(@PathVariable Integer candidateId) {
		Candidate oneCandidate = candidateService.getOneCandidate(candidateId);
		
		return  ResponseEntity.ok(oneCandidate);
		
	}
	
	
	@PutMapping("/{candidateId}")
	
	public ResponseEntity<Candidate> updateOneCandidate(@PathVariable Integer candidateId, @RequestBody CandidateUpdateRequest updateCandidate) {
		
		return new  ResponseEntity<Candidate> (candidateService.updateOneCandidate(candidateId, updateCandidate),HttpStatus.OK);
		
	}
	
	@DeleteMapping("/{candidateId}")
	
	public ResponseEntity<String> deleteOneCandidate(@PathVariable Integer candidateId) {
		candidateService.deleteOneCandidate(candidateId);
		
		return new ResponseEntity<String>("EMPLOYEE HAS BEEN DELETED SUCCESSFULLY!",HttpStatus.OK);
	}

}
