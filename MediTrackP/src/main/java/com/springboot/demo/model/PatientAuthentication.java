package com.springboot.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="P_Authentication")
public class PatientAuthentication {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long pAId;
	
	@Column(name="email_Id")
	private String emailId;
	
	@Column(name= "p_Key")
	private String key;

	public PatientAuthentication() {
		super();
	}

	public PatientAuthentication(String emailId, String key) {
		super();
		this.emailId = emailId;
		this.key = key;
	}

	public long getpAId() {
		return pAId;
	}

	public void setpAId(long pAId) {
		this.pAId = pAId;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
}
