package com.accolite.placements.daoTests;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.accolite.placements.dao.PlacedCandidateDaoImpl;
import com.accolite.placements.models.PlacedCandidate;
import com.accolite.placements.models.PlacedCandidateId;

import junit.framework.TestCase;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:./src/main/webapp/WEB-INF/placement-servlet.xml" })
@Transactional
public class PlacedCandidateDaoImplTest extends TestCase {

	@Autowired
	private PlacedCandidateDaoImpl placedCandidateDaoImpl;
	
	@Test
	@Rollback(true)
	public void testCreatePlacedCandidate() {
		PlacedCandidate placedCandidate = new PlacedCandidate(new PlacedCandidateId("raghu", "accolite"), "2017", 9.80);
		boolean result = placedCandidateDaoImpl.createPlacedCandidate(placedCandidate);
		assertTrue(result);
	}

	@Test
	@Rollback(true)
	public void testGetPlacedCandidatesByCompanyName() {
		PlacedCandidate placedCandidate = new PlacedCandidate(new PlacedCandidateId("raghu", "accolite"), "2017", 9.80);
		placedCandidateDaoImpl.createPlacedCandidate(placedCandidate);
		List<PlacedCandidate> placedCandidates = placedCandidateDaoImpl.getPlacedCandidatesByCompanyName("accolite");
		assertEquals(9.80, placedCandidates.get(0).getPayPackage());
	}

	@Test
	@Rollback(true)
	public void testGetPLacedCandidatesByYear() {
		PlacedCandidate placedCandidate = new PlacedCandidate(new PlacedCandidateId("raghu", "accolite"), "2017", 9.80);
		placedCandidateDaoImpl.createPlacedCandidate(placedCandidate);
		List<PlacedCandidate> placedCandidates = placedCandidateDaoImpl.getPlacedCandidatesByYear("2017");
		assertEquals(9.80, placedCandidates.get(0).getPayPackage());
	}
	
	@Test
	@Rollback(true)
	public void testGetAllPlacedCandidates() {
		PlacedCandidate placedCandidate = new PlacedCandidate(new PlacedCandidateId("raghu", "accolite"), "2017", 9.80);
		placedCandidateDaoImpl.createPlacedCandidate(placedCandidate);
		List<PlacedCandidate> placedCandidates = placedCandidateDaoImpl.getAllPlacedCandidates();
		assertEquals(9.80, placedCandidates.get(0).getPayPackage());	
	}

}
