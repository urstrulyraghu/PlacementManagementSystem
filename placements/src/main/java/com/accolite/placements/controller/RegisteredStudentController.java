package com.accolite.placements.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.accolite.placements.dao.RegisteredStudentDaoImpl;
import com.accolite.placements.models.RegisteredStudent;

@RestController
public class RegisteredStudentController {
	
	@Autowired
    private RegisteredStudentDaoImpl registeredStudentDaoImpl;
    
    /*** Retrieve a single RegisteredStudent ***/
    @RequestMapping(value="/RegisteredStudent/{studentName}", produces="application/json",
            method=RequestMethod.GET)
    public List<RegisteredStudent> getRegisteredStudentsByStudentName(@PathVariable("studentName") String studentName){
        return registeredStudentDaoImpl.getRegisteredStudentsByStudentName(studentName);
    }
    
    @RequestMapping(value="/RegisteredStudent/{companyName}", produces="application/json",
            method=RequestMethod.GET)
    public List<RegisteredStudent> getRegisteredStudentsByCompanyName(@PathVariable("companyName") String companyName){
        return registeredStudentDaoImpl.getRegisteredStudentsByCompanyName(companyName);
    }
    
    /*** Retrieve all RegisteredStudents ***/
    @RequestMapping(value="/RegisteredStudents", produces="application/json",
            method=RequestMethod.GET)
    public List<RegisteredStudent> getAllRegisteredStudents()
    {
        return registeredStudentDaoImpl.getAllRegisteredStudents();
    }

}
