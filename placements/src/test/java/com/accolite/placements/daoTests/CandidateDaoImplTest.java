package com.accolite.placements.daoTests;

import java.util.List;

import org.aspectj.lang.annotation.Before;
import org.aspectj.weaver.NewFieldTypeMunger;
import org.junit.BeforeClass;
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

	static ApplicationContext context;

	@Autowired
	private CandidateDaoImpl candidateDaoImpl;
	
	@Test
	@Rollback(true)
	public void testCreateCandidate() {
		Candidate candidate = new Candidate("raghu","abcd","be",45.6,56.7,78.9,"email");
		boolean result = candidateDaoImpl.createCandidate(candidate);
		assertTrue(result);
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
		Candidate candidate1 = new Candidate("raghu","abcd","be",49.6,76.7,78.9,"email");
		boolean result = candidateDaoImpl.updateCandidate(candidate1);
		assertTrue(result);
	}

}
