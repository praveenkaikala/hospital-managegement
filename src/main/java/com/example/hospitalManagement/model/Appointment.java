package com.example.hospitalManagement.model;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "patientId",nullable = false)
    private Patient patient;

    @ManyToOne
    @JoinColumn(name="doctorId",nullable = false)
    private Doctor doctor;

    private String date;
}
