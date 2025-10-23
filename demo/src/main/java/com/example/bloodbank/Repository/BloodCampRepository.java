package com.example.bloodbank.Repository;

import com.example.bloodbank.entity.BloodCamp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BloodCampRepository extends JpaRepository<BloodCamp, Long> {
}
