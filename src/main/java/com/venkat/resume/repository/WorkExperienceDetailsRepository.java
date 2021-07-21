package com.venkat.resume.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.venkat.resume.model.AcademicDetails;
import com.venkat.resume.model.WorkExperienceDetails;
@Repository
public interface WorkExperienceDetailsRepository extends JpaRepository<WorkExperienceDetails,Integer> {


	List<WorkExperienceDetails> findAll();
	@Query("SELECT wxd from WorkExperienceDetails wxd where resume_fk=?1")
	List<WorkExperienceDetails> findByResumeId(@Param("resumeId") int resumeId);
}
