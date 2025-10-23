package com.example.bloodbank.Controller;

import com.example.bloodbank.entity.StorageUnit;
import com.example.bloodbank.service.StorageUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/storage-units")
public class StorageUnitController {

    @Autowired
    private StorageUnitService storageUnitService;

    // Create a new storage unit
    @PostMapping
    public ResponseEntity<StorageUnit> createStorageUnit(@RequestBody StorageUnit storageUnit) {
        StorageUnit savedUnit = storageUnitService.saveStorageUnit(storageUnit);
        return ResponseEntity.ok(savedUnit);
    }
    // Get all storage units
    @GetMapping
    public ResponseEntity<List<StorageUnit>> getAllStorageUnits() {
        List<StorageUnit> units = storageUnitService.getAllStorageUnits();
        return ResponseEntity.ok(units);
    }

    // Get storage unit by ID
    @GetMapping("/{id}")
    public ResponseEntity<StorageUnit> getStorageUnitById(@PathVariable Long id) {
        return storageUnitService.getStorageUnitById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Update a storage unit
    @PutMapping("/{id}")
    public ResponseEntity<StorageUnit> updateStorageUnit(@PathVariable Long id, @RequestBody StorageUnit unitDetails) {
        return storageUnitService.getStorageUnitById(id)
                .map(unit -> {
                    unit.setBloodGroup(unitDetails.getBloodGroup());
                    unit.setDonor(unitDetails.getDonor());
                    unit.setVolume(unitDetails.getVolume());
                    unit.setExpiryDate(unitDetails.getExpiryDate());
                    unit.setCollectionDate(unitDetails.getCollectionDate());
                    StorageUnit updatedUnit = storageUnitService.saveStorageUnit(unit);
                    return ResponseEntity.ok(updatedUnit);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // Delete a storage unit
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStorageUnit(@PathVariable Long id) {
        storageUnitService.deleteStorageUnit(id);
        return ResponseEntity.ok("Storage unit deleted successfully");
    }
}
