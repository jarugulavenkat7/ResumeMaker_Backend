package com.venkat.resume.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.venkat.resume.model.PersonalDetails;

public interface PersonalDetailsRepository extends JpaRepository<PersonalDetails,Integer> {

}
