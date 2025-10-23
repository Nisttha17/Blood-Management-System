package com.example.bloodbank.Repository;

import com.example.bloodbank.entity.BloodBank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BloodBankRepository extends JpaRepository<BloodBank, Long> {
    
}
