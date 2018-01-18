package com.accolite.placements.models;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;


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
