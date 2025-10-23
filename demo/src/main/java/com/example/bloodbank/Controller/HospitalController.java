package com.example.bloodbank.Controller;

import com.example.bloodbank.entity.Hospital;
import com.example.bloodbank.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hospitals")
public class HospitalController {

    @Autowired
    private HospitalService hospitalService;

    // Create a new hospital
    @PostMapping
    public ResponseEntity<Hospital> createHospital(@RequestBody Hospital hospital) {
        Hospital savedHospital = hospitalService.saveHospital(hospital);
        return ResponseEntity.ok(savedHospital);
    }

    // Get all hospitals
    @GetMapping
    public ResponseEntity<List<Hospital>> getAllHospitals() {
        List<Hospital> hospitals = hospitalService.getAllHospitals();
        return ResponseEntity.ok(hospitals);
    }

    // Get hospital by ID
    @GetMapping("/{id}")
    public ResponseEntity<Hospital> getHospitalById(@PathVariable Long id) {
        return hospitalService.getHospitalById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Update a hospital
    @PutMapping("/{id}")
    public ResponseEntity<Hospital> updateHospital(@PathVariable Long id, @RequestBody Hospital hospitalDetails) {
        return hospitalService.getHospitalById(id)
                .map(hospital -> {
                    hospital.setName(hospitalDetails.getName());
                    hospital.setAddress(hospitalDetails.getAddress());
                    hospital.setRegistrationDate(hospitalDetails.getRegistrationDate());
                    hospital.setAssociatedBloodBank(hospitalDetails.getAssociatedBloodBank());
                    Hospital updatedHospital = hospitalService.saveHospital(hospital);
                    return ResponseEntity.ok(updatedHospital);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // Delete a hospital
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteHospital(@PathVariable Long id) {
        hospitalService.deleteHospital(id);
        return ResponseEntity.ok("Hospital deleted successfully");
    }
}
