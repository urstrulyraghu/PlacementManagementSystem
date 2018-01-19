package com.accolite.placements.dao;

import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.accolite.placements.models.PlacedCandidate;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class PlacedCandidateDaoImpl implements PlacedCandidateDao{

	@PersistenceContext
    private EntityManager entityManager;

	public boolean createPlacedCandidate(PlacedCandidate placedCandidate) {
		try {
			entityManager.persist(placedCandidate);
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}

	public List<PlacedCandidate> getPlacedCandidatesByCompanyName(String companyName) {
		return entityManager.createQuery("Select stu from PlacedCandidate where studentName = " + companyName).getResultList();
	}
	
	public List<PlacedCandidate> getAllPlacedCandidates() {
		return entityManager.createQuery("select stu from PlacedCandidate").getResultList();
	}

	public List<PlacedCandidate> getPlacedCandidatesByYear(String year) {
		return entityManager.createQuery("Select stu from PlacedCandidate where year = " + year).getResultList();
	}

}
