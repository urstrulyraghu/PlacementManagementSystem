package com.accolite.placements.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.accolite.placements.models.Candidate;
import com.accolite.placements.dao.CandidateDao;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class CandidateDaoImpl implements CandidateDao{

	    @PersistenceContext
		private EntityManager entityManager;
	
	    public boolean createCandidate(Candidate candidate)
	    {
	    		entityManager.persist(candidate);
	    		return true;
	    }

	    public Candidate getCandidateByName(String name)
	    {
	    	return entityManager.find(Candidate.class, name);
	    }

	    
	    public List<Candidate> getAllCandidates()
	    {
	        return entityManager.createQuery("SELECT stu from Candidate stu").getResultList();
	    }

	    public boolean updateCandidate(Candidate candidate)
	    {
	    		entityManager.merge(candidate);
	    		return true;
	    }
}
