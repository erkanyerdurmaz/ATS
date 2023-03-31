package com.example.appCandidate.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.appCandidate.entities.Candidate;

public interface CandidateRepository extends JpaRepository<Candidate,Integer>  {

}
