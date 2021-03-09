package com.springboot.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PatientDetails")
public class Patient {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long pid2;
	@Column(name= "first_name")
	private String firtName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="gender")
	private String gender;
	
	@Column(name="email_Id")
	private String emailId;
	
	@Column(name= "password")
	private String password;
	
	@Column(name="age")
	private String age;
	
	@Column(name="ContactNo")
	private String contactNo;
	
	@Column(name="aadhar_No")
	private String aadharNo;
	
	@Column(name="address")
	private String address;
	
	public Patient() {
		super();
	}
	public Patient(String firtName, String lastName, String gender, String emailId, String password, String age,
			String contactNo, String aadharNo, String address) {
		super();
		this.firtName = firtName;
		this.lastName = lastName;
		this.gender = gender;
		this.emailId = emailId;
		this.password = password;
		this.age = age;
		this.contactNo = contactNo;
		this.aadharNo = aadharNo;
		this.address = address;
	}
	public long getPid2() {
		return pid2;
	}
	public void setPid2(long pid2) {
		this.pid2 = pid2;
	}
	public String getFirtName() {
		return firtName;
	}
	public void setFirtName(String firtName) {
		this.firtName = firtName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
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
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public String getAadharNo() {
		return aadharNo;
	}
	public void setAadharNo(String aadharNo) {
		this.aadharNo = aadharNo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
