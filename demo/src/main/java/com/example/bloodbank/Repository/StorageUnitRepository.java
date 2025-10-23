package com.example.bloodbank.Repository;

import com.example.bloodbank.entity.StorageUnit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StorageUnitRepository extends JpaRepository<StorageUnit, Long> {
    // JpaRepository already provides CRUD methods
}
