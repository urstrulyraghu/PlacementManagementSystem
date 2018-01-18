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

	public void createPlacedCandidate(PlacedCandidate placedCandidate) {
		entityManager.persist(placedCandidate);
	}

	public PlacedCandidate getPlacedCandidateByCandidateName(String studentName) {
		return (PlacedCandidate)entityManager.createQuery("Select stu from PlacedCandidate where studentName = " + studentName).getSingleResult();
	}

	public PlacedCandidate getPlacedCandidateByCompanyName(String companyName) {
		return (PlacedCandidate)entityManager.createQuery("Select stu from PlacedCandidate where studentName = " + companyName).getSingleResult();
	}
	
	public List<PlacedCandidate> getAllPlacedCandidates() {
		return entityManager.createQuery("select stu from PlacedCandidate").getResultList();
	}

	public void updatePlacedCandidate(PlacedCandidate placedCandidate) {
		entityManager.merge(placedCandidate);
	}

}
