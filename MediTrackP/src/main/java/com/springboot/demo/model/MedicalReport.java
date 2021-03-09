package com.springboot.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PMedicalReport")
public class MedicalReport {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long reportId;
	@Column(name = "doctor_name")
	private String doctorName;
	@Column(name="receptionist_name")
	private String receptionistName;
	@Column(name="diseseName")
	private String disese;
	
	@Column(name="testName")
	private String tests;
	
	@Column(name="appointmentDt")
	private String nextAppoitnmentDt;
	
	@Column(name="clinicN")
	private String clinicName;
	
	@Column(name="p_id")
	private int pid;

	public long getReportId() {
		return reportId;
	}

	public void setReportId(long reportId) {
		this.reportId = reportId;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public MedicalReport() {
		super();
	}

	public MedicalReport(String doctorName, String receptionistName, String disese, String tests,
			String nextAppoitnmentDt, String clinicName, int pid) {
		super();
		this.doctorName = doctorName;
		this.receptionistName = receptionistName;
		this.disese = disese;
		this.tests = tests;
		this.nextAppoitnmentDt = nextAppoitnmentDt;
		this.clinicName = clinicName;
		this.pid = pid;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getReceptionistName() {
		return receptionistName;
	}

	public void setReceptionistName(String receptionistName) {
		this.receptionistName = receptionistName;
	}

	public String getDisese() {
		return disese;
	}

	public void setDisese(String disese) {
		this.disese = disese;
	}

	public String getTests() {
		return tests;
	}

	public void setTests(String tests) {
		this.tests = tests;
	}

	public String getNextAppoitnmentDt() {
		return nextAppoitnmentDt;
	}

	public void setNextAppoitnmentDt(String nextAppoitnmentDt) {
		this.nextAppoitnmentDt = nextAppoitnmentDt;
	}

	public String getClinicName() {
		return clinicName;
	}

	public void setClinicName(String clinicName) {
		this.clinicName = clinicName;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}
	
	

}
