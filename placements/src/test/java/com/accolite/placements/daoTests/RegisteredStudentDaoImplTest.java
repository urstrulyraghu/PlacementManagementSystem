package com.accolite.placements.daoTests;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.accolite.placements.dao.RegisteredStudentDaoImpl;
import com.accolite.placements.models.RegStudent;
import com.accolite.placements.models.RegisteredStudent;

import junit.framework.TestCase;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:./src/main/webapp/WEB-INF/placement-servlet.xml" })
@Transactional
public class RegisteredStudentDaoImplTest extends TestCase {

	@Autowired
	private RegisteredStudentDaoImpl registeredStudentDaoImpl;
	
	@Test
	@Rollback(true)
	public void testCreateRegisteredStudent() {
		RegisteredStudent registeredStudent = new RegisteredStudent(new RegStudent("raghu", "accolite"));
		boolean result = registeredStudentDaoImpl.createRegisteredStudent(registeredStudent);
		assertTrue(result);
	}

	@Test
	@Rollback(true)
	public void testGetRegisteredStudentsByStudentName() {
		RegisteredStudent registeredStudent = new RegisteredStudent(new RegStudent("raghu", "accolite"));
		registeredStudentDaoImpl.createRegisteredStudent(registeredStudent);
		List<RegisteredStudent> studentsTest = registeredStudentDaoImpl.getRegisteredStudentsByStudentName("raghu");
		assertEquals("accolite", studentsTest.get(0).getRegStudent().getCompanyName());
		
	}

	@Test
	@Rollback(true)
	public void testGetRegisteredStudentsByCompanyName() {
		RegisteredStudent registeredStudent = new RegisteredStudent(new RegStudent("raghu", "accolite"));
		registeredStudentDaoImpl.createRegisteredStudent(registeredStudent);
		List<RegisteredStudent> studentsTest = registeredStudentDaoImpl.getRegisteredStudentsByCompanyName("accolite");
		assertEquals("raghu", studentsTest.get(0).getRegStudent().getStudentName());	
	}

	@Test
	@Rollback(true)
	public void testGetAllRegisteredStudents() {
		RegisteredStudent registeredStudent = new RegisteredStudent(new RegStudent("raghu", "accolite"));
		registeredStudentDaoImpl.createRegisteredStudent(registeredStudent);
	}

}
