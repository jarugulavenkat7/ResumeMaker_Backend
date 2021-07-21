package com.venkat.resume.model;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name="Resume")
public class Resume {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@OneToMany(targetEntity = AcademicDetails.class,cascade = CascadeType.ALL)
	@JoinColumn(name="resume_fk",referencedColumnName = "id")
	private List<AcademicDetails> academicDetailsList;
	@OneToMany(targetEntity = WorkExperienceDetails.class,cascade = CascadeType.ALL)
	@JoinColumn(name="resume_fk",referencedColumnName = "id")
	private List<WorkExperienceDetails> workExperienceDetailsList;
	
	@OneToOne(targetEntity = PersonalDetails.class, cascade = CascadeType.ALL)
	private PersonalDetails personalDetails;
	
	@OneToOne(targetEntity = AddressDetails.class, cascade = CascadeType.ALL)
	private AddressDetails addressDetails;
	
	@OneToOne(targetEntity = ContactDetails.class, cascade = CascadeType.ALL)
	private ContactDetails contactDetails;
	
	@OneToOne(targetEntity = Image.class, cascade = CascadeType.ALL)
	private Image image;
	
	public Image getImage() {
		return image;
	}
	public void setImage(Image image) {
		this.image = image;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public List<AcademicDetails> getAcademicDetailsList() {
		return academicDetailsList;
	}
	public void setAcademicDetailsList(List<AcademicDetails> academicDetailsList) {
		this.academicDetailsList = academicDetailsList;
	}
	public List<WorkExperienceDetails> getWorkExperienceDetailsList() {
		return workExperienceDetailsList;
	}
	public void setWorkExperienceDetailsList(List<WorkExperienceDetails> workExperienceDetailsList) {
		this.workExperienceDetailsList = workExperienceDetailsList;
	}
	public PersonalDetails getPersonalDetails() {
		return personalDetails;
	}
	public void setPersonalDetails(PersonalDetails personalDetails) {
		this.personalDetails = personalDetails;
	}
	public AddressDetails getAddressDetails() {
		return addressDetails;
	}
	public void setAddressDetails(AddressDetails addressDetails) {
		this.addressDetails = addressDetails;
	}
	public ContactDetails getContactDetails() {
		return contactDetails;
	}
	public void setContactDetails(ContactDetails contactDetails) {
		this.contactDetails = contactDetails;
	}
	
	

}
