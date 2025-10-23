package com.example.bloodbank.service;

import com.example.bloodbank.entity.BloodCamp;
import com.example.bloodbank.Repository.BloodCampRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BloodCampService {

    private final BloodCampRepository bloodCampRepository;

    public BloodCampService(BloodCampRepository bloodCampRepository) {
        this.bloodCampRepository = bloodCampRepository;
    }

    // Create or Update
    public BloodCamp saveCamp(BloodCamp camp) {
        return bloodCampRepository.save(camp);
    }

    // Get all
    public List<BloodCamp> getAllCamps() {
        return bloodCampRepository.findAll();
    }

    // Get by ID
    public Optional<BloodCamp> getCampById(Long id) {
        return bloodCampRepository.findById(id);
    }

    // Delete by ID
    public void deleteCamp(Long id) {
        bloodCampRepository.deleteById(id);
    }
}
