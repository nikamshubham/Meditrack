package com.springboot.demo.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DOCTORS")
public class Doctor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long doctorId;
	
	@Column(name = "doctor_name")
	private String doctorName;
	
	@Column(name = "email_id")
	private String emailId;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "education")
	private String education;
	
	@Column(name = "specialization")
	private String specialization;
	
	@Column(name = "working_days")
	private String workingDays;
	
	

	public long getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(long doctorId) {
		this.doctorId = doctorId;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public String getWorkingDays() {
		return workingDays;
	}

	public void setWorkingDays(String workingDays) {
		this.workingDays = workingDays;
	}

	@Override
	public String toString() {
		return "Doctor [doctorId=" + doctorId + ", doctorName=" + doctorName + ", emailId=" + emailId + ", password="
				+ password + ", education=" + education + ", specialization=" + specialization + ", workingDays="
				+ workingDays + "]";
	}

	public Doctor(long doctorId, String doctorName, String emailId, String password, String education,
			String specialization, String workingDays) {
		super();
		this.doctorId = doctorId;
		this.doctorName = doctorName;
		this.emailId = emailId;
		this.password = password;
		this.education = education;
		this.specialization = specialization;
		this.workingDays = workingDays;
	}

	public Doctor() {
		super();
	}
	
	

}

