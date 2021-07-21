package com.venkat.resume.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.venkat.resume.model.Resume;
@Repository
public interface ResumeRepository extends JpaRepository<Resume,Integer> {

}
