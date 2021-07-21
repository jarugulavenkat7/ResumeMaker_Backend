package com.venkat.resume.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="AcademicDetails")
public class AcademicDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer id;
private String courseName;
private String institutionName;
private String universityOrBoard;
private String yearOfPassing;
private double gpaOrPercentage;
private String degree;
private String state;
private String country;

public String getDegree() {
	return degree;
}
public void setDegree(String degree) {
	this.degree = degree;
}
public String getState() {
	return state;
}
public void setState(String state) {
	this.state = state;
}
public String getCountry() {
	return country;
}
public void setCountry(String country) {
	this.country = country;
}
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getCourseName() {
	return courseName;
}
public void setCourseName(String courseName) {
	this.courseName = courseName;
}
public String getInstitutionName() {
	return institutionName;
}
public void setInstitutionName(String institutionName) {
	this.institutionName = institutionName;
}
public String getUniversityOrBoard() {
	return universityOrBoard;
}
public void setUniversityOrBoard(String universityOrBoard) {
	this.universityOrBoard = universityOrBoard;
}
public String getYearOfPassing() {
	return yearOfPassing;
}
public void setYearOfPassing(String yearOfPassing) {
	this.yearOfPassing = yearOfPassing;
}
public double getGpaOrPercentage() {
	return gpaOrPercentage;
}
public void setGpaOrPercentage(double gpaOrPercentage) {
	this.gpaOrPercentage = gpaOrPercentage;
}

}