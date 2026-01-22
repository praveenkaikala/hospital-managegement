package com.example.hospitalManagement.repository;

import com.example.hospitalManagement.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


@Component
public interface DoctorRepo extends JpaRepository<Doctor,Long> {
}
