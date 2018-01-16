package com.accolite.placements.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Candidate")
public class Candidate {
	
	String name;
	String password;
	String edQual;
	double sscPercentage;
	double intPercentage;
	double degPercentage;
	Company company;
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
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	public Candidate(String name, String password, String edQual, double sscPercentage, double intPercentage,
			double degPercentage, Company company) {
		super();
		this.name = name;
		this.password = password;
		this.edQual = edQual;
		this.sscPercentage = sscPercentage;
		this.intPercentage = intPercentage;
		this.degPercentage = degPercentage;
		this.company = company;
	}
	
	

}
