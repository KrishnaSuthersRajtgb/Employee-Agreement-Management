package com.javaproject.Employee_Agreement_Management_System.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.javaproject.Employee_Agreement_Management_System.entity.EmploymentAgreement;
import com.javaproject.Employee_Agreement_Management_System.service.EmploymentAgreementService;

import java.util.Optional;
import java.util.List;

@RestController
@RequestMapping("/api/employment-agreements")
public class EmploymentAgreementController {

    @Autowired
    private EmploymentAgreementService service;

    @PostMapping
    public ResponseEntity<EmploymentAgreement> createAgreement(@RequestBody EmploymentAgreement agreement) {
        EmploymentAgreement savedAgreement = service.createAgreement(agreement);
        return ResponseEntity.ok(savedAgreement);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmploymentAgreement> getAgreement(@PathVariable Long id) {
        Optional<EmploymentAgreement> agreement = service.getAgreement(id);
        return agreement.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmploymentAgreement> updateAgreement(
            @PathVariable Long id, @RequestBody EmploymentAgreement agreementDetails) {
        EmploymentAgreement updatedAgreement = service.updateAgreement(id, agreementDetails);
        return ResponseEntity.ok(updatedAgreement);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAgreement(@PathVariable Long id) {
        service.deleteAgreement(id);
        return ResponseEntity.ok("Employment Agreement deleted successfully.");
    }
    
    
    @GetMapping
    public ResponseEntity<List<EmploymentAgreement>> getAllEmploymentAgreements() {
        List<EmploymentAgreement> agreements = service.getAllEmploymentAgreements();
        return ResponseEntity.ok(agreements);
    }
}
