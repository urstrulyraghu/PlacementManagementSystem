package com.accolite.placements.daoTests;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import com.accolite.placements.dao.CandidateDaoImpl;
import com.accolite.placements.models.Candidate;

import junit.framework.TestCase;

public class CandidateDaoImplTest extends TestCase {


	@Autowired
	private CandidateDaoImpl candidateDaoImpl;
	
	@Test
	@Rollback(true)
	public void testCreateCandidate() {
		Candidate candidate = new Candidate("raghu","abcd","be",45.6,56.7,78.9,"email");
		candidateDaoImpl.createCandidate(candidate);
	}

	@Test
	@Rollback(true)
	public void testGetCandidateByName() {
		Candidate candidate = new Candidate("raghu","abcd","be",45.6,56.7,78.9,"email");
		candidateDaoImpl.createCandidate(candidate);
		Candidate candidateTest = candidateDaoImpl.getCandidateByName("raghu");
		assertEquals("be", candidateTest.getEdQual());
	}
	
	@Test
	@Rollback(true)
	public void testGetAllCandidates() {
		Candidate candidate = new Candidate("raghu","abcd","be",45.6,56.7,78.9,"email");
		candidateDaoImpl.createCandidate(candidate);
		List<Candidate> candidates= candidateDaoImpl.getAllCandidates();
		assertEquals(candidate, candidates.get(0));
	}

	@Test
	@Rollback(true)
	public void testUpdateCandidate() {
		Candidate candidate = new Candidate("raghu","abcd","be",45.6,56.7,78.9,"email");
		candidateDaoImpl.createCandidate(candidate);
		Candidate candidate1 = new Candidate("raghu","abcd","be",45.6,76.7,78.9,"email");
		candidateDaoImpl.updateCandidate(candidate1);
	}

}
