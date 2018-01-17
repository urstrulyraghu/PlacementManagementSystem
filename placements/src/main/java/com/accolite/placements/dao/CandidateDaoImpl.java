package com.accolite.placements.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
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
	
	    public void createCandidate(Candidate candidate)
	    {
	        entityManager.persist(candidate);
	    }

	    public Candidate getCandidateById(long idcandidate)
	    {
	        return entityManager.find(Candidate.class,idcandidate);
	    }

	    
	    public List<Candidate> getAllCandidates()
	    {
	        return entityManager.createQuery("select stu from Candidate stu").getResultList();
	    }

	    public void updateCandidate(Candidate candidate)
	    {
	        entityManager.merge(candidate);
	    }

	    public void deleteCandidate(long idcandidate)
	    {
	        Candidate s = entityManager.find(Candidate.class,idcandidate);
	        entityManager.remove(s);
	    }
}
