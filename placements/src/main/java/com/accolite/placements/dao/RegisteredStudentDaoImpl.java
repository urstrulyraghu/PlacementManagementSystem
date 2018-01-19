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

	public void createRegisteredStudent(RegisteredStudent registeredStudent) {
		entityManager.persist(registeredStudent);
	}

	public RegisteredStudent getRegisteredStudentByStudentName(String studentName) {
		return (RegisteredStudent)entityManager.createQuery("Select * from RegisteredStudent where studentName = " + studentName).getSingleResult();
	}

	public RegisteredStudent getRegisteredStudentByCompanyName(String companyName) {
		return (RegisteredStudent)entityManager.createQuery("Select * from RegisteredStudent where companyName = " + companyName).getSingleResult();
	}


	public void updateRegisteredStudent(RegisteredStudent registeredStudent) {
		entityManager.merge(registeredStudent);
	}

	public List<RegisteredStudent> getAllRegisteredStudents() {
        return entityManager.createQuery("select stu from RegisteredStudent stu").getResultList();
	}
}
