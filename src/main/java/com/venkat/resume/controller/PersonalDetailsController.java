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
import com.venkat.resume.model.PersonalDetails;
import com.venkat.resume.model.Resume;
import com.venkat.resume.repository.AcademicDetailsRepository;
import com.venkat.resume.repository.ContactDetailsRepository;
import com.venkat.resume.repository.PersonalDetailsRepository;
import com.venkat.resume.repository.ResumeRepository;
@CrossOrigin("*")
@RestController

public class PersonalDetailsController {
	@Autowired
	private ResumeRepository resumeRepository;

	@Autowired
	private PersonalDetailsRepository personalDetailsRepository;
	
	@PostMapping("resumes/{resumeId}/personalDetails")
	public void addPersonalDetails(@PathVariable int resumeId,@RequestBody PersonalDetails personalDetails)  {
		Resume resume=resumeRepository.getOne(resumeId);
		resume.setPersonalDetails(personalDetails);
		resumeRepository.save(resume);
		//academicDetailsRepository.save(academicDetails);
		
	}
	
	@GetMapping("resumes/{resumeId}/personalDetails")
	public PersonalDetails getPersonalDetails(@PathVariable int resumeId) {
		Resume resume=resumeRepository.getOne(resumeId);
		return personalDetailsRepository.getOne(resume.getPersonalDetails().getId());
	}
	

	@DeleteMapping("resumes/{resumeId}/personalDetails/{personalDetailsId}")
	public void deletePersonalDetails(@PathVariable int personalDetailsId,@PathVariable int resumeId) {
		//PersonalDetails personalDetails = personalDetailsRepository.findById(personalDetailsId).get();
		resumeRepository.findById(resumeId).get().setPersonalDetails(null);
		personalDetailsRepository.deleteById(personalDetailsId);
		
		//return personalDetails;
	}
	
	@PutMapping("resumes/{resumeId}/personalDetails/{personalDetailsId}")
	public void updatePersonalDetails(@RequestBody PersonalDetails personalDetails) {
		personalDetailsRepository.save(personalDetails);
	}
}
