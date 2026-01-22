package com.example.hospitalManagement.service;

import com.example.hospitalManagement.model.Bill;
import com.example.hospitalManagement.repository.BillRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class BillService {

    private static final Logger logger =
            LoggerFactory.getLogger(BillService.class);

    private final BillRepo repo;

    // Constructor Injection
    public BillService(BillRepo repo) {
        this.repo = repo;
    }

    // Create Bill
    public String createBill(Bill bill) {
        try {
            repo.save(bill);
            logger.info("Bill created successfully: {}", bill);
            return "Bill created successfully";
        } catch (Exception e) {
            logger.error("Unable to create bill", e);
            return "Unable to create bill";
        }
    }

    // Get All Bills
    public List<Bill> getAllBills() {
        try {
            logger.info("Fetching all bills");
            return repo.findAll();
        } catch (Exception e) {
            logger.error("Unable to fetch bills", e);
            return Collections.emptyList();
        }
    }

    // Get Bill By ID
    public Optional<Bill> getBillById(Long id) {
        try {
            logger.info("Fetching bill with id: {}", id);
            return repo.findById(id);
        } catch (Exception e) {
            logger.error("Unable to fetch bill with id: {}", id, e);
            return Optional.empty();
        }
    }

    // Update Bill Status
    public String updateBillStatus(Long id, String status) {
        try {
            Optional<Bill> billOpt = repo.findById(id);
            if (billOpt.isPresent()) {
                Bill bill = billOpt.get();
                bill.setStatus(status);
                repo.save(bill);
                logger.info("Bill status updated for id {} to {}", id, status);
                return "Bill status updated successfully";
            } else {
                logger.warn("Bill not found with id: {}", id);
                return "Bill not found";
            }
        } catch (Exception e) {
            logger.error("Unable to update bill status for id: {}", id, e);
            return "Unable to update bill status";
        }
    }

    // Delete Bill
    public String deleteBill(Long id) {
        try {
            repo.deleteById(id);
            logger.info("Bill deleted successfully with id: {}", id);
            return "Bill deleted successfully";
        } catch (Exception e) {
            logger.error("Unable to delete bill with id: {}", id, e);
            return "Unable to delete bill";
        }
    }
}
