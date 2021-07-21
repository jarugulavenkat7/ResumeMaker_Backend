package com.venkat.resume.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.venkat.resume.model.AcademicDetails;
import com.venkat.resume.model.ContactDetails;
import com.venkat.resume.model.Resume;
import com.venkat.resume.repository.AcademicDetailsRepository;
import com.venkat.resume.repository.ContactDetailsRepository;
import com.venkat.resume.repository.ResumeRepository;
@CrossOrigin(origins = "*")
@RestController

public class ContactDetailsController {
	@Autowired
	private ResumeRepository resumeRepository;

	@Autowired
	private ContactDetailsRepository contactDetailsRepository;
	
	@PostMapping("resumes/{resumeId}/contactDetails")
	public void addContactDetails(@PathVariable int resumeId,@RequestBody ContactDetails contactDetails)  {
		Resume resume=resumeRepository.getOne(resumeId);
		resume.setContactDetails(contactDetails);
		resumeRepository.save(resume);
		//academicDetailsRepository.save(academicDetails);
		
	}
	
	@GetMapping("resumes/{resumeId}/contactDetails")
	public ContactDetails getContactDetails(@PathVariable int resumeId) {
		Resume resume=resumeRepository.getOne(resumeId);
		return contactDetailsRepository.getOne(resume.getContactDetails().getId());
	}
	

	@DeleteMapping("resumes/{resumeId}/contactDetails/{contactDetailsId}")
	public void deleteContactDetails(@PathVariable int contactDetailsId,@PathVariable int resumeId) throws InterruptedException {
		//ContactDetails contactDetails = contactDetailsRepository.findById(contactDetailsId).get();
		Resume resume=resumeRepository.findById(resumeId).get();
		resume.setContactDetails(null);
		resumeRepository.save(resume);
		
		contactDetailsRepository.deleteById(contactDetailsId);
	
		//return contactDetails;
	}
	
	@PutMapping("resumes/{resumeId}/contactDetails/{contactDetailsId}")
	public void updateContactDetails(@RequestBody ContactDetails contactDetails) {
		contactDetailsRepository.save(contactDetails);
	}
}
