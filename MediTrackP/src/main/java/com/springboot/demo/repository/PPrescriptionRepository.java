package com.springboot.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.demo.model.PPrescription;


@Repository
public interface PPrescriptionRepository extends JpaRepository<PPrescription, Long>{

	
	//get medicine details
	List<PPrescription> findByPid1(int id);

	PPrescription findByMedicineId(Long id);

	List<PPrescription> findByPid1AndStatus1(int id, String string);

	

	


}
