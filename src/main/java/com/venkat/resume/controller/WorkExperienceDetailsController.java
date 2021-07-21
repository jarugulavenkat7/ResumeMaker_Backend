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
import com.venkat.resume.model.WorkExperienceDetails;
import com.venkat.resume.repository.ResumeRepository;
import com.venkat.resume.repository.WorkExperienceDetailsRepository;

@CrossOrigin(origins ="*")
@RestController
public class WorkExperienceDetailsController {
	@Autowired
	private ResumeRepository resumeRepository;

	@Autowired
	private WorkExperienceDetailsRepository workExperienceDetailsRepository;
	
	@PostMapping("resumes/{resumeId}/workExperienceDetails")
	public String addWorkExperienceDetails(@PathVariable int resumeId,@RequestBody WorkExperienceDetails workExperienceDetails)  {
		String message="";
		int id=workExperienceDetails.getId();
		if(id==-1) {
			Resume resume=resumeRepository.getOne(resumeId);
			resume.getWorkExperienceDetailsList().add(workExperienceDetails);
			resumeRepository.save(resume);
			message="New Educational Details are added";
		}
		else {
			workExperienceDetailsRepository.save(workExperienceDetails);
			message="Work Experience details are updated";
		}
		//academicDetailsRepository.save(academicDetails);
		return message;
	}
	
	@GetMapping("resumes/{resumeId}/workExperienceDetails")
	public List<WorkExperienceDetails> getWorkExperienceDetailsList(@PathVariable int resumeId) {
		return workExperienceDetailsRepository.findByResumeId(resumeId);
	}
	
	@GetMapping("resumes/{resumeId}/workExperienceDetails/{workExperienceDetailsId}")
	public WorkExperienceDetails getWorkExperienceDetails(@PathVariable int workExperienceDetailsId) {
		WorkExperienceDetails workExperienceDetails = workExperienceDetailsRepository.findById(workExperienceDetailsId).get();
		return workExperienceDetails;
	}

	@DeleteMapping("resumes/{resumeId}/workExperienceDetails/{workExperienceDetailsId}")
	public WorkExperienceDetails deleteWorkExperienceDetails(@PathVariable int workExperienceDetailsId) {
		WorkExperienceDetails workExperienceDetails = workExperienceDetailsRepository.findById(workExperienceDetailsId).get();
		workExperienceDetailsRepository.deleteById(workExperienceDetailsId);
		return workExperienceDetails;
	}
	
	@PutMapping("resumes/{resumeId}/workExperienceDetails/{workExperienceDetailsId}")
	public void updateWorkExperienceDetails(@RequestBody WorkExperienceDetails workExperienceDetails) {
		workExperienceDetailsRepository.save(workExperienceDetails);
	}
}

