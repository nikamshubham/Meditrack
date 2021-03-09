package com.springboot.demo.controller;

import java.util.Objects;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.demo.model.Receptionist;
import com.springboot.demo.repository.DoctorRepository;
import com.springboot.demo.repository.ReceptionistRepository;

@CrossOrigin(origins="*",allowedHeaders = "*")
@RestController
@RequestMapping("/MediTrackProject1")
public class ReceptionistController {
	
	@Autowired
	private DoctorRepository doctorRepository;
	
	@Autowired
	private ReceptionistRepository receptionistRepository; 
	
	@Autowired
	  private JavaMailSender javaMailSender;

	
	@CrossOrigin(origins = "http://localhost:4200")
	
	/*@GetMapping("/receptionist")
	public List<Receptionist> getAllReceptionist(){
		return receptionistrepository.findAll();
	} */
	 
	
	@PostMapping(value="/Receptionistlogin")
	@ResponseBody
	public Receptionist Receptionistlogin(@RequestBody Receptionist Recp,HttpSession Session) {
		
		Receptionist dt = receptionistRepository.findByEmailAdressAndPassword(Recp.getEmailAdress(),Recp.getPassword());
		if(Objects.nonNull(dt)) {
			//Recp.setReceptionistName("success");
			return dt;
		}
		else {
			Recp.setReceptionistName("fail");
			return dt;
		}
	}
	
	@PostMapping("/checkReceptionistEmail")
	@ResponseBody
	public Receptionist checkPatientEmail(@RequestBody Receptionist p,HttpSession Session)
	{
		Receptionist dt= receptionistRepository.findByEmailAdress(p.getEmailAdress());
		if(Objects.nonNull(dt)) 
		{
			return dt;
		}
		else 
		{
			p.setReceptionistName("fail");
			return dt;
		}
	}
	
	@PostMapping("/sendReceptPasswordByEmail")
	public void sendPasswordByEmail(@RequestBody Receptionist rpr) {
		Receptionist recept=receptionistRepository.findByEmailAdress(rpr.getEmailAdress());
		System.out.println("ttttttttttt");
		SimpleMailMessage msg = new SimpleMailMessage();
		System.out.println("ttttttttttt");
			String mail = recept.getEmailAdress();
			msg.setTo(mail);
			msg.setSubject("MEDITRACK HEALTH CARE Get Your Password");
			msg.setText("Hello, "+recept.getEmailAdress()+" Your Password is "+recept.getPassword()+"\n Your Regards - MEDITRACK HEALTHCARE");
			javaMailSender.send(msg);
			//System.out.println("Inside Confirmed loop");
	}
         
	
	@PostMapping("/checkReceptEmailPass")
	@ResponseBody
	public Receptionist checkReceptEmailPass(@RequestBody Receptionist rpr ,HttpSession Session)
	{
		Receptionist dt= receptionistRepository.findByEmailAdressAndPassword(rpr.getEmailAdress(), rpr.getPassword());
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

 @PostMapping("/changeReceptPass")
	public ResponseEntity<Receptionist> changeReceptPass(@RequestBody Receptionist rpr){
		
		
	 Receptionist updateReceptionistPassword= receptionistRepository.save(rpr);
		return ResponseEntity.ok(updateReceptionistPassword);
		
	}
}


