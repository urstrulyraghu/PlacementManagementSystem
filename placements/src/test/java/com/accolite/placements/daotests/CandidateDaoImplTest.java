package com.accolite.placements.daotests;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.accolite.placements.dao.CandidateDaoImpl;
import com.accolite.placements.models.Candidate;

import junit.framework.TestCase;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:./src/main/webapp/WEB-INF/placement-servlet.xml" })
@Transactional
public class CandidateDaoImplTest extends TestCase {

	static final String NAME = "raghu";
	static final String PWORD = "accolite";
	static final String EDQUAL = "Be";
	static final String EMAIL = "raghu@gmail.com";
	
	static ApplicationContext context;

	@Autowired
	private CandidateDaoImpl candidateDaoImpl;
	
	@Test
	@Rollback(true)
	public void testCreateCandidate() {
		Candidate candidate = new Candidate(NAME,PWORD,EDQUAL,45.6,56.7,78.9,EMAIL);
		boolean result = candidateDaoImpl.createCandidate(candidate);
		assertTrue(result);
	}

	@Test
	@Rollback(true)
	public void testGetCandidateByName() {
		
		Candidate candidate = new Candidate();
		candidate.setName(NAME);
		candidate.setPassword(PWORD);
		candidate.setEmail(EMAIL);
		candidate.setSscPercentage(45.6);
		candidate.setIntPercentage(56.7);
		candidate.setDegPercentage(78.9);
		candidate.setEdQual(EDQUAL);
		
		candidateDaoImpl.createCandidate(candidate);
		Candidate candidateTest = candidateDaoImpl.getCandidateByName(NAME);
		assertEquals(NAME, candidateTest.getName());
		assertEquals(PWORD, candidateTest.getPassword());
		assertEquals(EDQUAL, candidateTest.getEdQual());
		assertEquals(45.6, candidateTest.getSscPercentage());
		assertEquals(56.7, candidateTest.getIntPercentage());
		assertEquals(78.9, candidateTest.getDegPercentage());
		assertEquals(EMAIL, candidateTest.getEmail());
	}
	
	@Test
	@Rollback(true)
	public void testGetAllCandidates() {
		Candidate candidate = new Candidate(NAME,PWORD,EDQUAL,45.6,56.7,78.9,"email");
		candidateDaoImpl.createCandidate(candidate);
		List<Candidate> candidates= candidateDaoImpl.getAllCandidates();
		assertEquals(candidate, candidates.get(0));
	}

	@Test
	@Rollback(true)
	public void testUpdateCandidate() {
		Candidate candidate = new Candidate(NAME,PWORD,EDQUAL,45.6,56.7,78.9,EMAIL);
		candidateDaoImpl.createCandidate(candidate);
		Candidate candidate1 = new Candidate(NAME,PWORD,EDQUAL,49.6,76.7,78.9,EMAIL);
		boolean result = candidateDaoImpl.updateCandidate(candidate1);
		assertTrue(result);
	}

}
