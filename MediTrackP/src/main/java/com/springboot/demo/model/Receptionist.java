package com.springboot.demo.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="RECEPTIONIST")
public class Receptionist {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long receptionistId;
		@Column(name="receptionist_name")
		private String receptionistName;
		@Column(name="email_address")
		private String emailAdress;
		@Column(name="password")
		private String password;
		@Column(name="gender")
		private String gender;
		@Column(name="contact_no")
		private String contactNo;
		@Column(name="doctor_id")
		private int doctorId;
		
			
		public Receptionist() {
			
		}
		public Receptionist(Long receptionistId, String receptionistName, String emailAdress, String password,
				String gender, String contactNo, int doctorId) {
			super();
			this.receptionistId = receptionistId;
			this.receptionistName = receptionistName;
			this.emailAdress = emailAdress;
			this.password = password;
			this.gender = gender;
			this.contactNo = contactNo;
			this.doctorId = doctorId;
		}



		public Long getReceptionistId() {
			return receptionistId;
		}


		public void setReceptionistId(Long receptionistId) {
			this.receptionistId = receptionistId;
		}


		public String getReceptionistName() {
			return receptionistName;
		}


		public void setReceptionistName(String receptionistName) {
			this.receptionistName = receptionistName;
		}


		public String getEmailAdress() {
			return emailAdress;
		}


		public void setEmailAdress(String emailAdress) {
			this.emailAdress = emailAdress;
		}


		public String getPassword() {
			return password;
		}


		public void setPassword(String password) {
			this.password = password;
		}


		public String getGender() {
			return gender;
		}


		public void setGender(String gender) {
			this.gender = gender;
		}


		public String getContactNo() {
			return contactNo;
		}


		public void setContactNo(String contactNo) {
			this.contactNo = contactNo;
		}


		public int getDoctorId() {
			return doctorId;
		}


		public void setDoctorId(int doctorId) {
			this.doctorId = doctorId;
		}

}