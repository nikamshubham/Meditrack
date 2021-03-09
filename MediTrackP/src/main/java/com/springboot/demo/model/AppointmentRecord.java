package com.springboot.demo.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="AppointmentRecord")
public class AppointmentRecord {
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long recordId;
	@Column(name="receptionist_id")
	private Long receptionistId;
	@Column(name="patient_id")
	private Long patientId;	
	@Column(name="patient_name")
	private String patientName;
	@Column(name="appointment_date")
	private String appointmentDate;
	@Column(name="appointment_status")
	private String appointmentStatus;
	@Column(name="doctor_id")
	private long doctorId;
	
	public AppointmentRecord() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AppointmentRecord( Long receptionistId,long patientId, String patientName,String appointmentDate, String appointmentStatus,
			Long doctorId) {
		super();
		
		this.receptionistId = receptionistId;
		this.patientId = patientId;
		this.patientName = patientName;
		this.appointmentDate = appointmentDate;
		this.appointmentStatus = appointmentStatus;
		this.doctorId = doctorId;
	}

	public long getRecordId() {
		return recordId;
	}

	public void setRecordId(long recordId) {
		this.recordId = recordId;
	}

	public Long getReceptionistId() {
		return receptionistId;
	}

	public void setReceptionistId(Long receptionistId) {
		this.receptionistId = receptionistId;
	}

	public String getAppointmentDate() {
		return appointmentDate;
	}

	public Long getPatientId() {
		return patientId;
	}

	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}
	
	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	
	
	public void setAppointmentDate(String appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	public String getAppointmentStatus() {
		return appointmentStatus;
	}

	public void setAppointmentStatus(String appointmentStatus) {
		this.appointmentStatus = appointmentStatus;
	}

	public long getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(long doctorId) {
		this.doctorId = doctorId;
	}

	
		
}
