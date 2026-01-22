package com.example.hospitalManagement.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "appointmentId",nullable = false)
    Appointment appointment;
    private double amount;
    private String status;


    public void setStatus(String status) {
        this.status=status;
    }
}
