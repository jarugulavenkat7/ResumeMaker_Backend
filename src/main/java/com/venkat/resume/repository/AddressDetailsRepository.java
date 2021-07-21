package com.venkat.resume.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.venkat.resume.model.AddressDetails;


public interface AddressDetailsRepository extends JpaRepository<AddressDetails,Integer> {

}
