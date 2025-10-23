package com.example.bloodbank.Repository;

import com.example.bloodbank.entity.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital, Long> {
    // JpaRepository provides all CRUD methods
}
