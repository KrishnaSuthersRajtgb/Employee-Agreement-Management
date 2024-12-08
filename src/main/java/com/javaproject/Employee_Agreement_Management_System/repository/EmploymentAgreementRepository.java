package com.javaproject.Employee_Agreement_Management_System.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.javaproject.Employee_Agreement_Management_System.entity.*;

public interface EmploymentAgreementRepository extends JpaRepository<EmploymentAgreement, Long> {
}
