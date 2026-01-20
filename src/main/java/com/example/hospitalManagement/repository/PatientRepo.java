package com.example.hospitalManagement.repository;

import com.example.hospitalManagement.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepo extends JpaRepository<Patient,Long> {
}
