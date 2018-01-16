package com.accolite.placements.dao;

import java.util.List;

import com.accolite.placements.models.Candidate;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class CompanyDaoImpl implements CompanyDao{
	
	 	@PersistenceContext
	    private EntityManager entityManager;
	    
	    @Override
	    public void createCandidate(Candidate candidate)
	    {
	        entityManager.persist(candidate);
	    }

	    @Override
	    public Candidate getCandidateById(long id)
	    {
	        return entityManager.find(Candidate.class,id);
	    }

	    @Override
	    public List<Candidate> getAllCandidates()
	    {
	        return entityManager.createQuery("select stu from Candidate stu").getResultList();
	    }

	    @Override
	    public void updateCandidate(Candidate candidate)
	    {
	        entityManager.merge(candidate);
	    }

	    @Override
	    public void deleteCandidate(long id)
	    {
	        Candidate s = entityManager.find(Candidate.class,id);
	        entityManager.remove(s);
	    }
}
