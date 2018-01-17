package com.accolite.placements.models;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Company implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	String name;
	String jobRole;
	String description;
	String date;
	Double payPackage;
	
	
	public Company() {
		super();
	}
	
	@JsonCreator
	public Company(@JsonProperty("name")String name, @JsonProperty("jobRole")String jobRole, @JsonProperty("description")String description, @JsonProperty("date")String date, @JsonProperty("payPackage")Double payPackage) {
		super();
		this.name = name;
		this.jobRole = jobRole;
		this.description = description;
		this.date = date;
		this.payPackage = payPackage;
	}
	
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
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Double getPayPackage() {
		return payPackage;
	}
	public void setPayPackage(Double payPackage) {
		this.payPackage = payPackage;
	}
		
}
