package com.example.bloodbank.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "hospital")
public class Hospital {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hospital_id")
    private Long hospitalId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "registration_date")
    private LocalDate registrationDate;

    // Foreign Key to BloodInventory
    @ManyToOne
    @JoinColumn(name = "associated_blood_bank_id", nullable = false)
    private BloodBank associatedBloodBank;

    // ===== Constructors =====
    public Hospital() {}

    public Hospital(String name, String address, LocalDate registrationDate, BloodBank associatedBloodBank) {
        this.name = name;
        this.address = address;
        this.registrationDate = registrationDate;
        this.associatedBloodBank = associatedBloodBank;
    }

    // ===== Getters & Setters =====
    public Long getHospitalId() { return hospitalId; }
    public void setHospitalId(Long hospitalId) { this.hospitalId = hospitalId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public LocalDate getRegistrationDate() { return registrationDate; }
    public void setRegistrationDate(LocalDate registrationDate) { this.registrationDate = registrationDate; }

    public BloodBank getAssociatedBloodBank() { return associatedBloodBank; }
    public void setAssociatedBloodBank(BloodBank associatedBloodBank) { this.associatedBloodBank = associatedBloodBank; }
}
