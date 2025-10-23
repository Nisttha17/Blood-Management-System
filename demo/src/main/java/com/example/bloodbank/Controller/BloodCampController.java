package com.example.bloodbank.Controller;

import com.example.bloodbank.entity.BloodCamp;
import com.example.bloodbank.service.BloodCampService;   // ✅ use service, not entity
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bloodcamps")
public class BloodCampController {

    private final BloodCampService bloodCampService;   // ✅ use BloodCampService

    // Constructor Injection
    public BloodCampController(BloodCampService bloodCampService) {
        this.bloodCampService = bloodCampService;
    }

    // ➕ Create new camp
    @PostMapping
    public ResponseEntity<BloodCamp> createCamp(@RequestBody BloodCamp camp) {
        return ResponseEntity.ok(bloodCampService.saveCamp(camp));
    }

    // 📋 Get all camps
    @GetMapping
    public ResponseEntity<List<BloodCamp>> getAllCamps() {
        return ResponseEntity.ok(bloodCampService.getAllCamps());
    }

    // 🔎 Get camp by ID
    @GetMapping("/{id}")
    public ResponseEntity<BloodCamp> getCampById(@PathVariable Long id) {
        return bloodCampService.getCampById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // ✏ Update camp
    // @PutMapping("/{id}")
    // public ResponseEntity<BloodCamp> updateCamp(@PathVariable Long id, @RequestBody BloodCamp campDetails) {
    //     return bloodCampService.getCampById(id)
    //             .map(existingCamp -> {
    //                 existingCamp.setCampName(campDetails.getCampName());
    //                 existingCamp.setScheduleDate(campDetails.getScheduleDate());
    //                 existingCamp.setVenueId(campDetails.getVenueId());
    //                 existingCamp.setOrganisedBy(campDetails.getOrganisedBy());
    //                 existingCamp.setBloodBank(campDetails.getBloodBank());
    //                 existingCamp.setCertificationIssued(campDetails.getCertificationIssued());
    //                 return ResponseEntity.ok(bloodCampService.saveCamp(existingCamp));
    //             })
    //             .orElse(ResponseEntity.notFound().build());
    // }

    // ❌ Delete camp
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCamp(@PathVariable Long id) {
        bloodCampService.deleteCamp(id);
        return ResponseEntity.noContent().build();
    }
}
