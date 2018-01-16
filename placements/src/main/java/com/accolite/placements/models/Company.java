package com.accolite.placements.models;

import java.sql.Date;

public class Company {
	
	String name;
	String jobRole;
	String description;
	Date date;
	Double payPackage;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getJobRole() {
		return jobRole;
	}
	public void setJobRole(String jobRole) {
		this.jobRole = jobRole;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Double getPayPackage() {
		return payPackage;
	}
	public void setPayPackage(Double payPackage) {
		this.payPackage = payPackage;
	}
	public Company(String name, String jobRole, String description, Date date, Double payPackage) {
		super();
		this.name = name;
		this.jobRole = jobRole;
		this.description = description;
		this.date = date;
		this.payPackage = payPackage;
	}
	
	
}
