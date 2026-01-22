package com.example.hospitalManagement.service;

import com.example.hospitalManagement.model.Patient;
import com.example.hospitalManagement.repository.PatientRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    private static final Logger logger =
            LoggerFactory.getLogger(PatientService.class);

    private final PatientRepo repo;

    // Constructor Injection (Best Practice)
    public PatientService(PatientRepo repo) {
        this.repo = repo;
    }

    public String createPatient(Patient patient) {
        try {
            repo.save(patient);
            logger.info("Patient created successfully: {}", patient);
            return "Patient created successfully";
        } catch (Exception e) {
            logger.error("Unable to create patient", e);
            return "Unable to create patient";
        }
    }

    public List<Patient> getAllPatients() {
        try {
            logger.info("Fetching all patients");
            return repo.findAll();
        } catch (Exception e) {
            logger.error("Unable to fetch patients", e);
            return Collections.emptyList(); // safe fallback
        }
    }

    public Optional<Patient> getPatientById(Long id) {
        try {
            logger.info("Fetching Patient with id: {}", id);
            return repo.findById(id);
        } catch (Exception e) {
            logger.error("Unable to fetch Patient with id: {}", id, e);
            return Optional.empty();
        }
    }

    // Delete Doctor
    public String deletePatient(Long id) {
        try {
            repo.deleteById(id);
            logger.info("Patient deleted successfully with id: {}", id);
            return "Patient deleted successfully";
        } catch (Exception e) {
            logger.error("Unable to delete Patient with id: {}", id, e);
            return "Unable to delete Patient";
        }
    }
}
