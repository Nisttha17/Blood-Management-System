package com.example.bloodbank.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "storage_unit")
public class StorageUnit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "blood_id")
    private Long bloodId;

    @Column(name = "blood_group", nullable = false)
    private String bloodGroup;

    // Foreign Key to Donor
    @ManyToOne
    @JoinColumn(name = "donor_id", nullable = false)
    private Donor donor;

    @Column(name = "volume", nullable = false)
    private Integer volume; // in ml

    @Column(name = "expiry_date", nullable = false)
    private LocalDate expiryDate;

    @Column(name = "collection_date", nullable = false)
    private LocalDate collectionDate;

    // ===== Constructors =====
    public StorageUnit() {}

    public StorageUnit(String bloodGroup, Donor donor, Integer volume, LocalDate expiryDate, LocalDate collectionDate) {
        this.bloodGroup = bloodGroup;
        this.donor = donor;
        this.volume = volume;
        this.expiryDate = expiryDate;
        this.collectionDate = collectionDate;
    }

    // ===== Getters & Setters =====
    public Long getBloodId() { return bloodId; }
    public void setBloodId(Long bloodId) { this.bloodId = bloodId; }

    public String getBloodGroup() { return bloodGroup; }
    public void setBloodGroup(String bloodGroup) { this.bloodGroup = bloodGroup; }

    public Donor getDonor() { return donor; }
    public void setDonor(Donor donor) { this.donor = donor; }

    public Integer getVolume() { return volume; }
    public void setVolume(Integer volume) { this.volume = volume; }

    public LocalDate getExpiryDate() { return expiryDate; }
    public void setExpiryDate(LocalDate expiryDate) { this.expiryDate = expiryDate; }

    public LocalDate getCollectionDate() { return collectionDate; }
    public void setCollectionDate(LocalDate collectionDate) { this.collectionDate = collectionDate; }
}
