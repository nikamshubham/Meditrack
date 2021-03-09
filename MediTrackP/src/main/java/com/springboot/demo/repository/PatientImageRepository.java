package com.springboot.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.demo.model.PatientImage;

public interface PatientImageRepository extends JpaRepository<PatientImage, Long>{

	Optional<PatientImage> findByPid(int id);

	//void save(PatientImage img);
	//Optional<ImageModel> findByName(String name);

}
