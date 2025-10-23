package com.example.bloodbank.Repository;

import com.example.bloodbank.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    // You can add custom queries if needed
}
