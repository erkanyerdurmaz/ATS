package com.example.appCandidate;




import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.appCandidate.entities.Candidate;
import com.example.appCandidate.entities.CandidateStatu;
import com.example.appCandidate.repositories.CandidateRepository;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)

public class CandidateTest {
	
	@Autowired
	CandidateRepository candidateRepository;
	
	@Test
	@Order(1)
	public void testCreateCandidate() {
		Candidate c = new Candidate();
		c.setId(3);
		c.setCandidateFullName("Orhan");
		c.setCandidateStatu(CandidateStatu.HIRED);
		c.setEmail("orhanV@gmail.com");
		c.setJobRole("engineer");
		c.setLocation("Lüleburgaz");
		candidateRepository.save(c);
		assertNotNull(candidateRepository.findById(3).get());
	}
	
	@Test
	@Order(2)
	
	public void testAllCandidate() {
		
		List<Candidate> list = candidateRepository.findAll();
		assertThat(list).size().isGreaterThan(0);
		
	}

	@Test
	@Order(3)
	
	public void testOneCandidate() {
		Candidate candidate =candidateRepository.findById(3).get();
		assertEquals("Orhan",candidate.getCandidateFullName());
		assertEquals("orhanV@gmail.com",candidate.getEmail());
		assertEquals(CandidateStatu.HIRED,candidate.getCandidateStatu());
	}
	
	@Test
	@Order(4)
	
	public void testUpdateCandidate() {
		Candidate c =candidateRepository.findById(3).get();
		c.setCandidateFullName("Veli");
		c.setCandidateStatu(CandidateStatu.REJECTED);
		assertNotNull("Orhan",candidateRepository.findById(3).get().getCandidateFullName());
		assertNotNull(CandidateStatu.HIRED,candidateRepository.findById(3).get().getCandidateStatu().toString());
		
	}
	
   @Test
   @Order(5)
	
	public void testDeleteCandidate() {
	   
	candidateRepository.deleteById(3);
	assertThat(candidateRepository.existsById(3)).isFalse();
	
     }
	

}
