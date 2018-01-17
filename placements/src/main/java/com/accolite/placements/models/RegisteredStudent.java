package com.accolite.placements.models;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Embeddable
class RegStudent implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	String student;
	String company;
	
	public String getStudentName() {
		return student;
	}
	public void setStudentName(String studentName) {
		this.student = studentName;
	}
	public String getCompanyName() {
		return company;
	}
	public void setCompanyName(String companyName) {
		this.company = companyName;
	}

	public RegStudent(String studentName, String companyName) {
		super();
		this.student = studentName;
		this.company = companyName;
	}
	public RegStudent() {
		super();
	}
	
	
	
}

@Entity
@Table(name="registered_students")
public class RegisteredStudent implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EmbeddedId
	RegStudent regStudent;
	
	public RegStudent getRegStudent() {
		return regStudent;
	}
	public void setRegStudent(RegStudent regStudent) {
		this.regStudent = regStudent;
	}
	public RegisteredStudent(RegStudent regStudent) {
		super();
		this.regStudent = regStudent;
	}
	public RegisteredStudent() {
		super();
	}
	
}
