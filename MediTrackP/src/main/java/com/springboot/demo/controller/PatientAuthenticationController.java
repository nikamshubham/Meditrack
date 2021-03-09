package com.springboot.demo.controller;

import java.util.Objects;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.demo.model.PPrescription;
import com.springboot.demo.model.Patient;
import com.springboot.demo.model.PatientAuthentication;
import com.springboot.demo.repository.PatientAuthenticationRepository;
import com.springboot.demo.repository.PatientRepository;

@CrossOrigin(origins = "*", allowedHeaders = "*")
//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/MediTrackProject/authentication")
public class PatientAuthenticationController {

	@Autowired
	private PatientAuthenticationRepository patientAuthenticationRepository;
	
	@Autowired
	private PatientRepository patientRepository;
	
		@Autowired
	  private JavaMailSender javaMailSender;

	//patient authentication details for registeration permission
	@PostMapping("/pauthentication")
	@ResponseBody
	public PatientAuthentication patientAuth(@RequestBody PatientAuthentication p,HttpSession Session)
	{
		PatientAuthentication dt=patientAuthenticationRepository.findByEmailIdAndKey(p.getEmailId(),p.getKey() );
		if(Objects.nonNull(dt)) 
		{
			return dt;
		}
		else 
		{
			return dt;
		}
	}
	
	@PostMapping("/pauthkey")
	@ResponseBody
	public PatientAuthentication savePatientRegkey(@RequestBody PatientAuthentication dt) {
		System.out.println("Success");
		return patientAuthenticationRepository.save(dt);
	}
	
	@PostMapping("/sendKeyByEmail")
	public void sendEmail(@RequestBody PatientAuthentication apr) {
		
		SimpleMailMessage msg = new SimpleMailMessage();
			String mail = apr.getEmailId();
			msg.setTo(mail);
			msg.setSubject("MEDITRACK HEALTH CARE OTP For Approval");
			msg.setText("Hello, "+apr.getEmailId()+" Your OTP for Registration Approval is "+apr.getKey()+"\n Your Regards - MEDITRACK HEALTHCARE");
			javaMailSender.send(msg);
			//System.out.println("Inside Confirmed loop");
	}
	

	 @PostMapping("/sendPasswordByEmail")
		public void sendPasswordByEmail(@RequestBody Patient pp) {
			Patient pp1=patientRepository.findByEmailId(pp.getEmailId());
			System.out.println("ttttttttttt");
			System.out.println(pp1.getEmailId());
			System.out.println(pp.getEmailId());
			SimpleMailMessage msg = new SimpleMailMessage();
			System.out.println("ttttttttttt");
				String mail = pp1.getEmailId();
				msg.setTo(mail);
				msg.setSubject("MEDITRACK HEALTH CARE Get Your Password");
				msg.setText("Hello, "+pp1.getEmailId()+" Your Password is "+pp1.getPassword()+"\n Your Regards - MEDITRACK HEALTHCARE");
				javaMailSender.send(msg);
				System.out.println("Inside Confirmed loop");
		}
	 
	 @PostMapping("/checkPatientEmail")
		@ResponseBody
		public Patient checkPatientEmail(@RequestBody Patient p,HttpSession Session)
		{
			Patient dt=patientRepository.findByEmailId(p.getEmailId());
			if(Objects.nonNull(dt)) 
			{
				return dt;
			}
			else 
			{
				p.setAadharNo("fail");
				return dt;
			}
		}
	 
	 @PostMapping("/checkPEmailPass")
		@ResponseBody
		public Patient checkPEmailPass(@RequestBody Patient p,HttpSession Session)
		{
			Patient dt=patientRepository.findByEmailIdAndPassword(p.getEmailId(),p.getPassword());
			if(Objects.nonNull(dt)) 
			{
				return dt;
			}
			else 
			{
				//p.setAadharNo("fail");
				return dt;
			}
		}

	 @PostMapping("/changePPass")
		public ResponseEntity<Patient> changePPass(@RequestBody Patient pp1){
			
			
			Patient updateMedicineR=patientRepository.save(pp1);
			return ResponseEntity.ok(updateMedicineR);
			
		}
	 
	 @PostMapping("/checkMail")
		@ResponseBody
		public PatientAuthentication checkMail(@RequestBody Patient p,HttpSession Session)
		{
		 PatientAuthentication dt=patientAuthenticationRepository.findByEmailId(p.getEmailId());
			if(Objects.nonNull(dt)) 
			{
				System.out.println("constroller mail");
				return dt;
			}
			else 
			{
				//p.setAadharNo("fail");
				return dt;
			}
		}
	 
	
}
