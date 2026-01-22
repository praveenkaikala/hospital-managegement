package com.example.hospitalManagement.controller;

import com.example.hospitalManagement.model.Patient;
import com.example.hospitalManagement.service.PatientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/patients")
public class PatientController {

    private final PatientService patientService;

    // Constructor Injection
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    // Create Patient
    @PostMapping
    public ResponseEntity<String> createPatient(@RequestBody Patient patient) {
        String response = patientService.createPatient(patient);
        return ResponseEntity.ok().body(response);
    }

    // Get All Patients
    @GetMapping
    public ResponseEntity<List<Patient>> getAllPatients() {
        return ResponseEntity.ok(patientService.getAllPatients());
    }

    // Get Patient By ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getPatientById(@PathVariable Long id) {
        Optional<Patient> patient = patientService.getPatientById(id);
        return patient
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Delete Patient
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePatient(@PathVariable Long id) {
        String response = patientService.deletePatient(id);
        return ResponseEntity.ok(response);
    }
}
