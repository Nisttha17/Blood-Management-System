package com.example.bloodbank.Repository;

import com.example.bloodbank.entity.Donor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DonorRepository extends JpaRepository<Donor, Long> {
}
