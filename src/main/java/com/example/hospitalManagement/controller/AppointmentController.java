package com.example.hospitalManagement.controller;

import com.example.hospitalManagement.model.Appointment;
import com.example.hospitalManagement.service.AppointmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/appointments")
public class AppointmentController {

    private final AppointmentService appointmentService;

    // Constructor Injection
    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    // Create Appointment
    @PostMapping
    public ResponseEntity<String> createAppointment(@RequestBody Appointment appointment) {

        String response = appointmentService.createAppointment(appointment);
        return ResponseEntity.ok(response);
    }

    // Get All Appointments
    @GetMapping
    public ResponseEntity<List<Appointment>> getAllAppointments() {
        return ResponseEntity.ok(appointmentService.getAllAppointments());
    }

    // Get Appointment By ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getAppointmentById(@PathVariable Long id) {
        Optional<Appointment> appointment = appointmentService.getAppointmentById(id);
        return appointment
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Delete Appointment
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAppointment(@PathVariable Long id) {
        String response = appointmentService.deleteAppointment(id);
        return ResponseEntity.ok(response);
    }
}
