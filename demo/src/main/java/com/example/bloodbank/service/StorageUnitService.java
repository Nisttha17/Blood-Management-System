package com.example.bloodbank.service;

import com.example.bloodbank.entity.StorageUnit;
import com.example.bloodbank.Repository.StorageUnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StorageUnitService {

    @Autowired
    private StorageUnitRepository storageUnitRepository;

    // Save or update a StorageUnit
    public StorageUnit saveStorageUnit(StorageUnit storageUnit) {
        return storageUnitRepository.save(storageUnit);
    }

    // Get all StorageUnits
    public List<StorageUnit> getAllStorageUnits() {
        return storageUnitRepository.findAll();
    }

    // Get StorageUnit by ID
    public Optional<StorageUnit> getStorageUnitById(Long id) {
        return storageUnitRepository.findById(id);
    }

    // Delete StorageUnit by ID
    public void deleteStorageUnit(Long id) {
        storageUnitRepository.deleteById(id);
    }
}
