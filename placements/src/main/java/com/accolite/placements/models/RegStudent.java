package com.accolite.placements.models;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class RegStudent implements Serializable{
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((company == null) ? 0 : company.hashCode());
		result = prime * result + ((student == null) ? 0 : student.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RegStudent other = (RegStudent) obj;
		if (company == null) {
			if (other.getCompanyName() != null)
				return false;
		} else if (!company.equals(other.getCompanyName()))
			return false;
		if (student == null) {
			if (other.getStudentName() != null)
				return false;
		} else if (!student.equals(other.getStudentName()))
			return false;
		return true;
	}
	
	
	
	
}