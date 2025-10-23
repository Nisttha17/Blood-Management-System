package com.example.bloodbank.Controller;

import com.example.bloodbank.entity.BloodBank;
import com.example.bloodbank.Repository.BloodBankRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bloodbank")
public class BloodBankController {

    @Autowired
    private BloodBankRepository bloodBankRepository;

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello! This is the Blood Bank Controller";
    }

    @GetMapping("/all")
    public List<BloodBank> getAllBloodBanks() {
        return bloodBankRepository.findAll();
    }

    @PostMapping("/add")
    public ResponseEntity<BloodBank> createBloodBank(@RequestBody BloodBank bloodBank) {
        BloodBank savedBloodBank = bloodBankRepository.save(bloodBank);
        return ResponseEntity.ok(savedBloodBank);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BloodBank> getBloodBankById(@PathVariable Long id) {
        Optional<BloodBank> bloodBank = bloodBankRepository.findById(id);
        return bloodBank.map(ResponseEntity::ok)
                        .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBloodBankById(@PathVariable Long id) {
        if (bloodBankRepository.existsById(id)) {
            bloodBankRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
