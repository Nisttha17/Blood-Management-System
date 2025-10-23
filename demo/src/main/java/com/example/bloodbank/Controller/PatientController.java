package com.example.bloodbank.Controller;

import com.example.bloodbank.entity.Patient;
import com.example.bloodbank.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;

    // Create new patient
    @PostMapping
    public Patient createPatient(@RequestBody Patient patient) {
        return patientService.savePatient(patient);
    }

    // Get all patients
    @GetMapping
    public List<Patient> getAllPatients() {
        return patientService.getAllPatients();
    }

    // Get patient by ID
    @GetMapping("/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable Long id) {
        return patientService.getPatientById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Update patient
    @PutMapping("/{id}")
    public ResponseEntity<Patient> updatePatient(@PathVariable Long id, @RequestBody Patient patientDetails) {
        return patientService.getPatientById(id).map(patient -> {
            patient.setName(patientDetails.getName());
            patient.setAge(patientDetails.getAge());
            patient.setGender(patientDetails.getGender());
            patient.setBloodGroup(patientDetails.getBloodGroup());
            patient.setDisease(patientDetails.getDisease());
            patient.setContactNumber(patientDetails.getContactNumber());
            patient.setAddress(patientDetails.getAddress());
            patient.setAdmissionDate(patientDetails.getAdmissionDate());
            patient.setHospital(patientDetails.getHospital());
            Patient updatedPatient = patientService.savePatient(patient);
            return ResponseEntity.ok(updatedPatient);
        }).orElse(ResponseEntity.notFound().build());
    }

    // Delete patient
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePatient(@PathVariable Long id) {
        if (patientService.getPatientById(id).isPresent()) {
            patientService.deletePatient(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
