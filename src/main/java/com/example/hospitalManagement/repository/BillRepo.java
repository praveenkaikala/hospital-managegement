package com.example.hospitalManagement.repository;

import com.example.hospitalManagement.model.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillRepo extends JpaRepository<Bill,Long> {
}
