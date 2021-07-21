package com.venkat.resume.controller;

import java.util.List;

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
import com.venkat.resume.model.Resume;
import com.venkat.resume.repository.AcademicDetailsRepository;
import com.venkat.resume.repository.ResumeRepository;
@CrossOrigin(origins = "*")
@RestController

public class AcademicDetailsController {
	@Autowired
	private ResumeRepository resumeRepository;

	@Autowired
	private AcademicDetailsRepository academicDetailsRepository;
	
	@PostMapping("resumes/{resumeId}/academicDetails")
	public String addAcademicDetails(@PathVariable int resumeId,@RequestBody AcademicDetails academicDetails)  {
		String message="";
		int id=academicDetails.getId();
		if(id==-1) {
			Resume resume=resumeRepository.getOne(resumeId);
			resume.getAcademicDetailsList().add(academicDetails);
			resumeRepository.save(resume);
			message="New Educational Details are added";
		}
		else {
			academicDetailsRepository.save(academicDetails);
			message="Educational details are updated";
		}
		//academicDetailsRepository.save(academicDetails);
		return message;
	}
	
	@GetMapping("resumes/{resumeId}/academicDetails")
	public List<AcademicDetails> getAcademicDetailsList(@PathVariable int resumeId) {
		return academicDetailsRepository.findByResumeId(resumeId);
	}
	

	@DeleteMapping("resumes/{resumeId}/academicDetails/{academicDetailsId}")
	public AcademicDetails deleteAcademicDetails(@PathVariable int academicDetailsId) {
		AcademicDetails academicDetails = academicDetailsRepository.findById(academicDetailsId).get();
		academicDetailsRepository.deleteById(academicDetailsId);
		return academicDetails;
	}
	@GetMapping("resumes/{resumeId}/academicDetails/{academicDetailsId}")
	public AcademicDetails getAcademicDetails(@PathVariable int academicDetailsId) {
		AcademicDetails academicDetails = academicDetailsRepository.findById(academicDetailsId).get();
		return academicDetails;
	}
	
	
	@PutMapping("resumes/{resumeId}/academicDetails/{academicDetailsId}")
	public void updateAcademicDetails(@RequestBody AcademicDetails academicDetails) {
		academicDetailsRepository.save(academicDetails);
	}
}
