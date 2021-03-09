package com.springboot.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.demo.model.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long>{

	List<Doctor> findAll();

	Doctor findByDoctorId(long doctorId);

}
