package com.accolite.placements.dao;

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
			entityManager.persist(placedCandidate);
			return true;
	}

	
	public List<PlacedCandidate> getAllPlacedCandidates() {
		return entityManager.createQuery("select stu from PlacedCandidate stu").getResultList();
	}

	public List<PlacedCandidate> getPlacedCandidatesByYear(String year) {
		return entityManager.createQuery("Select stu from PlacedCandidate stu where year = " + year).getResultList();
	}

}
