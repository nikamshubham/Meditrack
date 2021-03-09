package com.springboot.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.demo.model.AppointmentRecord;

@Repository
public interface AppointmentRecordRepository extends JpaRepository<AppointmentRecord, Long>{

	List<AppointmentRecord> findByReceptionistIdAndAppointmentStatus(Long id, String string);

	List<AppointmentRecord> findByReceptionistId(Long id);

	AppointmentRecord findByRecordId(Long id);

}
