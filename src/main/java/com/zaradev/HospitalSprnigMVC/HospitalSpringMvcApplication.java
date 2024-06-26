package com.zaradev.HospitalSprnigMVC;

import com.zaradev.HospitalSprnigMVC.entities.Patient;
import com.zaradev.HospitalSprnigMVC.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class HospitalSpringMvcApplication implements CommandLineRunner {

	@Autowired
	PatientRepository patientRepository;

	public static void main(String[] args) {
		SpringApplication.run(HospitalSpringMvcApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {

//		patientRepository.save(new Patient(null, "Ahmed", new Date(), true, 23));
//		patientRepository.save(new Patient(null, "Salma", new Date(), false,34));
//		patientRepository.save(new Patient(null, "Imane", new Date(), false,1098));

	}
}
