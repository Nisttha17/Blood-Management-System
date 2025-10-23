package com.example.bloodbank.Repository;

import com.example.bloodbank.entity.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportRepository extends JpaRepository<Report, Long> {
    // You can add custom queries if needed later
}
