package com.example.hospitalManagement.controller;

import com.example.hospitalManagement.model.Bill;
//import com.example.hospitalManagement.service.BillPdfService;
import com.example.hospitalManagement.service.BillService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/bills")
public class BillController {

    private final BillService billService;
//    private final BillPdfService billPdfService;

    // Constructor Injection
    public BillController(BillService billService) {
        this.billService = billService;
//        this.billPdfService = billPdfService;
    }

    // Create Bill
    @PostMapping
    public ResponseEntity<String> createBill(@RequestBody Bill bill) {
        return ResponseEntity.ok(billService.createBill(bill));
    }

    // Get All Bills
    @GetMapping
    public ResponseEntity<List<Bill>> getAllBills() {
        return ResponseEntity.ok(billService.getAllBills());
    }

    // Get Bill By ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getBillById(@PathVariable Long id) {
        Optional<Bill> bill = billService.getBillById(id);
        return bill
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Update Bill Status
    @PutMapping("/{id}/status")
    public ResponseEntity<String> updateBillStatus(
            @PathVariable Long id,
            @RequestParam String status) {

        return ResponseEntity.ok(
                billService.updateBillStatus(id, status)
        );
    }

    // Delete Bill
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBill(@PathVariable Long id) {
        return ResponseEntity.ok(billService.deleteBill(id));
    }

//    // Download Bill PDF
//    @GetMapping("/{id}/pdf")
//    public ResponseEntity<byte[]> downloadBillPdf(@PathVariable Long id) {
//
//        Bill bill = billService.getBillById(id)
//                .orElseThrow(() -> new RuntimeException("Bill not found"));
//
//        byte[] pdf = billPdfService.generateBillPdf(bill);
//
//        return ResponseEntity.ok()
//                .header(HttpHeaders.CONTENT_DISPOSITION,
//                        "attachment; filename=bill_" + id + ".pdf")
//                .contentType(MediaType.APPLICATION_PDF)
//                .body(pdf);
//    }
}
