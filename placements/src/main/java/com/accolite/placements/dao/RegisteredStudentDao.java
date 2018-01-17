package com.accolite.placements.dao;

import java.util.List;

import com.accolite.placements.models.RegisteredStudent;

public interface RegisteredStudentDao {
	
	public void createRegisteredStudent(RegisteredStudent registeredStudent);
    
    public RegisteredStudent getRegisteredStudentByStudentName(String studentName);
    
    public RegisteredStudent getRegisteredStudentByCompanyName(String companyName);
    
    public List<RegisteredStudent> getAllRegisteredStudents();
    
    public void updateRegisteredStudent(RegisteredStudent registeredStudent);
    
    public void deleteRegisteredStudent(String name);
}
