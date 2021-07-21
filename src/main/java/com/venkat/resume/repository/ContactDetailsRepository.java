package com.venkat.resume.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.venkat.resume.model.ContactDetails;

public interface ContactDetailsRepository extends JpaRepository<ContactDetails,Integer> {

}
