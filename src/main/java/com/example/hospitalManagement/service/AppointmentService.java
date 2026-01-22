package com.example.hospitalManagement.service;

import com.example.hospitalManagement.model.Appointment;
import com.example.hospitalManagement.repository.AppointmentRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {

    private static final Logger logger =
            LoggerFactory.getLogger(AppointmentService.class);

    private final AppointmentRepo repo;

    // Constructor Injection
    public AppointmentService(AppointmentRepo repo) {
        this.repo = repo;
    }

    // Create Appointment
    public String createAppointment(Appointment appointment) {
        try {
            repo.save(appointment);
            logger.info("Appointment created successfully: {}", appointment);
            return "Appointment created successfully";
        } catch (Exception e) {
            logger.error("Unable to create appointment", e);
            return "Unable to create appointment";
        }
    }

    // Get All Appointments
    public List<Appointment> getAllAppointments() {
        try {
            logger.info("Fetching all appointments");
            return repo.findAll();
        } catch (Exception e) {
            logger.error("Unable to fetch appointments", e);
            return Collections.emptyList();
        }
    }

    // Get Appointment By ID
    public Optional<Appointment> getAppointmentById(Long id) {
        try {
            logger.info("Fetching appointment with id: {}", id);
            return repo.findById(id);
        } catch (Exception e) {
            logger.error("Unable to fetch appointment with id: {}", id, e);
            return Optional.empty();
        }
    }

    // Delete Appointment
    public String deleteAppointment(Long id) {
        try {
            repo.deleteById(id);
            logger.info("Appointment deleted successfully with id: {}", id);
            return "Appointment deleted successfully";
        } catch (Exception e) {
            logger.error("Unable to delete appointment with id: {}", id, e);
            return "Unable to delete appointment";
        }
    }
}
