package com.example.bloodbank.Controller;

import com.example.bloodbank.entity.Donor;
import com.example.bloodbank.Repository.DonorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/donor")
public class DonorController {

    @Autowired
    private DonorRepository donorRepository;

    @PostMapping("/add")
    public ResponseEntity<Donor> createDonor(@RequestBody Donor donor) {
        return ResponseEntity.ok(donorRepository.save(donor));
    }

    @GetMapping("/all")
    public List<Donor> getAllDonors() {
        return donorRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Donor> getDonorById(@PathVariable Long id) {
        Optional<Donor> donor = donorRepository.findById(id);
        return donor.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDonor(@PathVariable Long id) {
        if (donorRepository.existsById(id)) {
            donorRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
