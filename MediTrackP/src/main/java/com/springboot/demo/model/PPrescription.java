package com.springboot.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="P_Prescription")
public class PPrescription {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long medicineId;
	@Column(name="medine_Name")
	private String medicineName;
	
	@Column(name="daily_Dosage")
	private String dailyDosage;
	
	@Column(name="from_Date")
	private String fromDate;
	@Column(name="upto_Date")
	private String uptoDate;
	
	@Column(name="statusR")
	private String status1;
	@Column(name="p_id1")
	private int pid1;
	public PPrescription() {
		super();
	}

	public PPrescription(String medicineName, String dailyDosage, String uptoDate, int pid1) {
		super();
		this.medicineName = medicineName;
		this.dailyDosage = dailyDosage;
		this.uptoDate = uptoDate;
		this.pid1 = pid1;
	}

	public long getMedicineId() {
		return medicineId;
	}

	public void setMedicineId(long medicineId) {
		this.medicineId = medicineId;
	}

	public String getMedicineName() {
		return medicineName;
	}

	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}

	public String getDailyDosage() {
		return dailyDosage;
	}

	public void setDailyDosage(String dailyDosage) {
		this.dailyDosage = dailyDosage;
	}

	public String getUptoDate() {
		return uptoDate;
	}

	public void setUptoDate(String uptoDate) {
		this.uptoDate = uptoDate;
	}

	public int getPid1() {
		return pid1;
	}

	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public String getStatus1() {
		return status1;
	}

	public void setStatus1(String status1) {
		this.status1 = status1;
	}

	public void setPid1(int pid1) {
		this.pid1 = pid1;
	}

	

	

}
