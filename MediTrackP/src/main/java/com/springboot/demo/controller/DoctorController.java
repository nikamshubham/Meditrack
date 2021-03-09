package com.springboot.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.springboot.demo.model.Doctor;

import com.springboot.demo.repository.DoctorRepository;

@CrossOrigin(origins="*",allowedHeaders = "*")
@RestController
@RequestMapping("/MediTrackProject1")
public class DoctorController {
	
	
	@Autowired
	private DoctorRepository doctorRepository;
	
	@CrossOrigin(origins = "http://localhost:4200")
	
	@GetMapping("/getdoctors")
	public List<Doctor> getAllDoctors() {
		return doctorRepository.findAll();
	}
	

}
