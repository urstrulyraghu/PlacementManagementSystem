package com.accolite.placements.daotests;

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

	static final String NAME = "accolite";
	static final String YEAR = "2017";
	
	@Autowired
	private PlacedCandidateDaoImpl placedCandidateDaoImpl;
	
	@Test
	@Rollback(true)
	public void testCreatePlacedCandidate() {
		PlacedCandidate placedCandidate = new PlacedCandidate(new PlacedCandidateId(YEAR, NAME), 45, 9.80);
		boolean result = placedCandidateDaoImpl.createPlacedCandidate(placedCandidate);
		assertTrue(result);
	}


	@Test
	@Rollback(true)
	public void testGetPLacedCandidatesByYear() {
		PlacedCandidate placedCandidate = new PlacedCandidate();
		PlacedCandidateId placedCandidateId = new PlacedCandidateId();
		placedCandidateId.setCompanyName(NAME);
		placedCandidateId.setYear(YEAR);
		placedCandidate.setPlacedCandidateId(placedCandidateId);
		placedCandidate.setCandidateCount(45);
		placedCandidate.setPayPackage(9.80);

		placedCandidateDaoImpl.createPlacedCandidate(placedCandidate);
		List<PlacedCandidate> placedCandidates = placedCandidateDaoImpl.getPlacedCandidatesByYear(YEAR);
		
		PlacedCandidateId placedCandidateIdTest = new PlacedCandidateId(YEAR, NAME);
		assertEquals(placedCandidateIdTest.hashCode(), placedCandidates.get(0).getPlacedCandidateId().hashCode());
		assertTrue(placedCandidateIdTest.equals(placedCandidates.get(0).getPlacedCandidateId()));
		assertEquals(9.80, placedCandidates.get(0).getPayPackage());
		assertEquals(YEAR,placedCandidates.get(0).getPlacedCandidateId().getYear());
		assertEquals(NAME,placedCandidates.get(0).getPlacedCandidateId().getCompanyName());
		assertEquals(45, placedCandidates.get(0).getCandidateCount());
	}
	
	@Test
	@Rollback(true)
	public void testGetAllPlacedCandidates() {
		PlacedCandidate placedCandidate = new PlacedCandidate(new PlacedCandidateId(YEAR, NAME), 45, 9.80);
		placedCandidateDaoImpl.createPlacedCandidate(placedCandidate);
		List<PlacedCandidate> placedCandidates = placedCandidateDaoImpl.getAllPlacedCandidates();
		assertEquals(9.80, placedCandidates.get(0).getPayPackage());	
	}

}
