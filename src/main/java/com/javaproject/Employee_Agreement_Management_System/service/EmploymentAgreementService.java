package com.javaproject.Employee_Agreement_Management_System.service;

import java.util.*;
import org.springframework.stereotype.Service;

import com.javaproject.Employee_Agreement_Management_System.entity.EmploymentAgreement;
import com.javaproject.Employee_Agreement_Management_System.repository.EmploymentAgreementRepository;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class EmploymentAgreementService {

    @Autowired
    private EmploymentAgreementRepository repository;

    public EmploymentAgreement createAgreement(EmploymentAgreement agreement) {
        return repository.save(agreement);
    }

    public Optional<EmploymentAgreement> getAgreement(Long id) {
        return repository.findById(id);
    }

    public EmploymentAgreement updateAgreement(Long id, EmploymentAgreement agreementDetails) {
        return repository.findById(id).map(agreement -> {
            agreement.setEmployeeName(agreementDetails.getEmployeeName());
            agreement.setRole(agreementDetails.getRole());
            agreement.setStartDate(agreementDetails.getStartDate());
            agreement.setEndDate(agreementDetails.getEndDate());
            agreement.setSalary(agreementDetails.getSalary());
            agreement.setTerms(agreementDetails.getTerms());
            return repository.save(agreement);
        }).orElseThrow(() -> new RuntimeException("Agreement not found"));
    }

    public List<EmploymentAgreement> getAllEmploymentAgreements() {
        return repository.findAll();
    }
    

    public void deleteAgreement(Long id) {
        repository.deleteById(id);
    }
}
