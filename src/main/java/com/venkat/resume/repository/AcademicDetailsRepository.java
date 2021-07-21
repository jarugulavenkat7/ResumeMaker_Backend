package com.venkat.resume.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.venkat.resume.model.AcademicDetails;

@Repository
public interface AcademicDetailsRepository extends JpaRepository<AcademicDetails,Integer> {

	List<AcademicDetails> findAll();
	@Query("SELECT ad from AcademicDetails ad where resume_fk=?1")
	List<AcademicDetails> findByResumeId(@Param("resumeId") int resumeId);
}
