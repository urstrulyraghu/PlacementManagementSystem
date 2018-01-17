package com.accolite.placements.models;


import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;


@Entity
public class Candidate implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id	
	String name;
	String password;
	String edQual;
	double sscPercentage;
	double intPercentage;
	double degPercentage;
		
	public Candidate() {
		super();
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEdQual() {
		return edQual;
	}
	public void setEdQual(String edQual) {
		this.edQual = edQual;
	}
	public double getSscPercentage() {
		return sscPercentage;
	}
	public void setSscPercentage(double sscPercentage) {
		this.sscPercentage = sscPercentage;
	}
	public double getIntPercentage() {
		return intPercentage;
	}
	public void setIntPercentage(double intPercentage) {
		this.intPercentage = intPercentage;
	}
	public double getDegPercentage() {
		return degPercentage;
	}
	public void setDegPercentage(double degPercentage) {
		this.degPercentage = degPercentage;
	}

	@JsonCreator
	public Candidate(@JsonProperty("name") String name,@JsonProperty("password") String password,@JsonProperty("edQual") String edQual,@JsonProperty("sscPercentage") double sscPercentage,@JsonProperty("intPercentage") double intPercentage,
			@JsonProperty("degPercentage")	double degPercentage) {
		super();
		this.name = name;
		this.password = password;
		this.edQual = edQual;
		this.sscPercentage = sscPercentage;
		this.intPercentage = intPercentage;
		this.degPercentage = degPercentage;
	}

	

}
