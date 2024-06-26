package com.zaradev.HospitalSprnigMVC.repository;

import com.zaradev.HospitalSprnigMVC.entities.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    Page<Patient> findByNomContains(String keyword, Pageable pageable);

    @Query("SELECT p FROM Patient p WHERE p.nom LIKE :x")
    Page<Patient> chercher(@Param("x") String keyword, Pageable pageable);

}
