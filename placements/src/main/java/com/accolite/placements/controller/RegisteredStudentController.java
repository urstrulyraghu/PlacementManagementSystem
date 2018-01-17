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
	
	/*** Creating a new RegisteredStudent ***/
    @RequestMapping(value="/create/RegisteredStudent", method=RequestMethod.POST, 
            produces="application/json", consumes="application/json")
    public void createRegisteredStudent(@RequestBody RegisteredStudent registeredStudent)
    {
        registeredStudentDaoImpl.createRegisteredStudent(registeredStudent);
    }
    
    /*** Retrieve a single RegisteredStudent ***/
    @RequestMapping(value="/RegisteredStudent/{studentName}", produces="application/json",
            method=RequestMethod.GET)
    public RegisteredStudent getRegisteredStudentByStudentName(@PathVariable("studentName") String studentName){
        return registeredStudentDaoImpl.getRegisteredStudentByStudentName(studentName);
    }
    
    @RequestMapping(value="/RegisteredStudent/{companyName}", produces="application/json",
            method=RequestMethod.GET)
    public RegisteredStudent getRegisteredStudentByCompanyName(@PathVariable("companyName") String companyName){
        return registeredStudentDaoImpl.getRegisteredStudentByCompanyName(companyName);
    }
    
    /*** Retrieve all RegisteredStudents ***/
    @RequestMapping(value="/RegisteredStudents", produces="application/json",
            method=RequestMethod.GET)
    public List<RegisteredStudent> getAllRegisteredStudents()
    {
        return registeredStudentDaoImpl.getAllRegisteredStudents();
    }
    
    /*** Update a RegisteredStudent ***/
    @RequestMapping(value="/update/RegisteredStudent", method=RequestMethod.PUT, 
            produces="application/json", consumes="application/json")
    public void updateRegisteredStudent(@RequestBody RegisteredStudent RegisteredStudent)
    {
        registeredStudentDaoImpl.updateRegisteredStudent(RegisteredStudent);
    }
}
