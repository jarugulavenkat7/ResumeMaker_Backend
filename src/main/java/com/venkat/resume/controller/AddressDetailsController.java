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
import com.venkat.resume.model.AddressDetails;
import com.venkat.resume.model.ContactDetails;
import com.venkat.resume.model.PersonalDetails;
import com.venkat.resume.model.Resume;
import com.venkat.resume.repository.AcademicDetailsRepository;
import com.venkat.resume.repository.AddressDetailsRepository;
import com.venkat.resume.repository.ContactDetailsRepository;
import com.venkat.resume.repository.PersonalDetailsRepository;
import com.venkat.resume.repository.ResumeRepository;
@CrossOrigin("*")
@RestController

public class AddressDetailsController {
	@Autowired
	private ResumeRepository resumeRepository;

	@Autowired
	private AddressDetailsRepository addressDetailsRepository;
	
	@PostMapping("resumes/{resumeId}/addressDetails")
	public void addAddressDetails(@PathVariable int resumeId,@RequestBody AddressDetails addressDetails)  {
		Resume resume=resumeRepository.getOne(resumeId);
		resume.setAddressDetails(addressDetails);
		resumeRepository.save(resume);
		//academicDetailsRepository.save(academicDetails);
		
	}
	
	@GetMapping("resumes/{resumeId}/addressDetails")
	public AddressDetails getAddressDetails(@PathVariable int resumeId) {
		Resume resume=resumeRepository.getOne(resumeId);
		return addressDetailsRepository.getOne(resume.getAddressDetails().getId());
	}
	

	@DeleteMapping("resumes/{resumeId}/addressDetails/{addressDetailsId}")
	public AddressDetails deleteAddressDetails(@PathVariable int addressDetailsId,@PathVariable int resumeId) {
		AddressDetails addressDetails = addressDetailsRepository.findById(addressDetailsId).get();
	Resume resume=	resumeRepository.findById(resumeId).get();
	resume.setAddressDetails(null);
	resumeRepository.save(resume);
		addressDetailsRepository.deleteById(addressDetailsId);
	
		return addressDetails;
	}
	
	@PutMapping("resumes/{resumeId}/addressDetails/{addressDetailsId}")
	public void updateAddressDetails(@RequestBody AddressDetails addressDetails) {
		addressDetailsRepository.save(addressDetails);
	}
}
