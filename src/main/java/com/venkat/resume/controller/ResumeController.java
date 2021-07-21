package com.venkat.resume.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;


import com.venkat.resume.model.Resume;
import com.venkat.resume.repository.ResumeRepository;
@CrossOrigin("*")
@RestController

public class ResumeController {
	@Autowired
	private ResumeRepository resumeRepository;

	@GetMapping("/resumes")
	public List<Resume> getAllComments() {
		return resumeRepository.findAll();
	}

	 @PostMapping("/resumes")
	 public int createResume(@RequestBody Resume resume) {
		 Resume  responseResume=resumeRepository.save(resume);
		 return responseResume.getId();
	  }
	 @GetMapping("resumes/{resumeId}") 
	 public Resume getResume(@PathVariable int resumeId) {
		 return resumeRepository.findById(resumeId).get();
	 }

		/*
		 * @PutMapping("resumes/{resumeId}") public String updateResume(@RequestBody
		 * Resume resume,@PathVariable int id) {
		 * 
		 * Resume retrivedResume=resumeRepository.getOne(id);
		 * retrivedResume.setAcademicDetailsList(resume.getAcademicDetailsList());
		 * retrivedResume.setAddressDetails(resume.getAddressDetails());
		 * retrivedResume.setContactDetails(resume.getContactDetails());
		 * retrivedResume.setPersonalDetails(resume.getPersonalDetails());
		 * retrivedResume.setWorkExperienceDetailsList(resume.
		 * getWorkExperienceDetailsList());
		 * 
		 * return "updated the id : "+resume.getId(); }
		 */
	 @DeleteMapping("resumes/{resumeId}")
		public int deleteResume(@PathVariable int resumeId) {
			Resume resume = resumeRepository.findById(resumeId).get();
			
			resumeRepository.deleteById(resumeId);
		
			return resume.getId();
		}
}
