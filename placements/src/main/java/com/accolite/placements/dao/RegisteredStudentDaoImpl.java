package com.accolite.placements.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.accolite.placements.models.RegisteredStudent;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class RegisteredStudentDaoImpl implements RegisteredStudentDao{
	
	 @PersistenceContext
	    private EntityManager entityManager;

	public boolean createRegisteredStudent(RegisteredStudent registeredStudent) {
		try {
			entityManager.persist(registeredStudent);
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}

	public List<RegisteredStudent> getRegisteredStudentsByStudentName(String studentName) {
		return entityManager.createQuery("Select stu from RegisteredStudent stu where studentName = " + studentName).getResultList();
	}

	public List<RegisteredStudent> getRegisteredStudentsByCompanyName(String companyName) {
		return entityManager.createQuery("Select stu from RegisteredStudent stu where companyName = " + companyName).getResultList();
	}


	public boolean updateRegisteredStudent(RegisteredStudent registeredStudent) {
		try {
			entityManager.merge(registeredStudent);
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}

	public List<RegisteredStudent> getAllRegisteredStudents() {
		return entityManager.createQuery("select stu from RegisteredStudent stu").getResultList();
	}

}
