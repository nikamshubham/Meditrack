package com.springboot.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.demo.model.PatientAuthentication;

@Repository
public interface PatientAuthenticationRepository extends JpaRepository<PatientAuthentication, Long> {
	//authentication for registration purpose
	PatientAuthentication findByEmailIdAndKey(String emailId, String key);

	PatientAuthentication findByEmailId(String emailId);

	
	
	

}
