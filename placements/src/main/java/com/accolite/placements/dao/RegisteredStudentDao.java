package com.accolite.placements.dao;

import java.util.List;

import com.accolite.placements.models.RegisteredStudent;

public interface RegisteredStudentDao {
	
	public boolean createRegisteredStudent(RegisteredStudent registeredStudent);
    
    public List<RegisteredStudent> getRegisteredStudentsByStudentName(String studentName);
    
    public List<RegisteredStudent> getRegisteredStudentsByCompanyName(String companyName);
    
    public List<RegisteredStudent> getAllRegisteredStudents();
        
}
