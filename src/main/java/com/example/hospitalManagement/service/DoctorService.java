package com.example.hospitalManagement.service;

import com.example.hospitalManagement.model.Doctor;
import com.example.hospitalManagement.repository.DoctorRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

    private static final Logger logger =
            LoggerFactory.getLogger(DoctorService.class);

    private final DoctorRepo repo;

    // Constructor Injection
    public DoctorService(DoctorRepo repo) {
        this.repo = repo;
    }

    // Create Doctor
    public String createDoctor(Doctor doctor) {
        try {
            repo.save(doctor);
            logger.info("Doctor created successfully: {}", doctor);
            return "Doctor created successfully";
        } catch (Exception e) {
            logger.error("Unable to create doctor", e);
            return "Unable to create doctor";
        }
    }

    // Get All Doctors
    public List<Doctor> getAllDoctors() {
        try {
            logger.info("Fetching all doctors");
            return repo.findAll();
        } catch (Exception e) {
            logger.error("Unable to fetch doctors", e);
            return Collections.emptyList();
        }
    }

    // Get Doctor By ID
    public Optional<Doctor> getDoctorById(Long id) {
        try {
            logger.info("Fetching doctor with id: {}", id);
            return repo.findById(id);
        } catch (Exception e) {
            logger.error("Unable to fetch doctor with id: {}", id, e);
            return Optional.empty();
        }
    }

    // Delete Doctor
    public String deleteDoctor(Long id) {
        try {
            repo.deleteById(id);
            logger.info("Doctor deleted successfully with id: {}", id);
            return "Doctor deleted successfully";
        } catch (Exception e) {
            logger.error("Unable to delete doctor with id: {}", id, e);
            return "Unable to delete doctor";
        }
    }
}
