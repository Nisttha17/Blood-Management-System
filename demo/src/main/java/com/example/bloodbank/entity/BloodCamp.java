package com.example.bloodbank.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "blood_camp")
public class BloodCamp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "blood_camp_id")
    private Long bloodCampId;

    @Column(name = "camp_name", nullable = false)
    private String campName;

    @Column(name = "schedule_date", nullable = false)
    private LocalDate scheduleDate;

    // Venue is not among selected entities, so it's kept as normal attribute
    @Column(name = "venue_id")
    private String venueId;
    

    @Column(name = "organised_by")
    private String organisedBy;

    // BloodCamp is linked to BloodInventory
    @ManyToOne
    @JoinColumn(name = "blood_bank_id", nullable = false)
    private BloodBank bloodBank;

    @Column(name = "certification_issued")
    private Boolean certificationIssued;

    // Getters and Setters
    public Long getBloodCampId() {
        return bloodCampId;
    }

    public void setBloodCampId(Long bloodCampId) {
        this.bloodCampId = bloodCampId;
    }

    public String getCampName() {
        return campName;
    }

    public void setCampName(String campName) {
        this.campName = campName;
    }

    public LocalDate getScheduleDate() {
        return scheduleDate;
    }

    public void setScheduleDate(LocalDate scheduleDate) {
        this.scheduleDate = scheduleDate;
    }

    public String getVenueId() {
        return venueId;
    }

    public void setVenueId(String venueId) {
        this.venueId = venueId;
    }

    public String getOrganisedBy() {
        return organisedBy;
    }

    public void setOrganisedBy(String organisedBy) {
        this.organisedBy = organisedBy;
    }

    public BloodBank getBloodBank() {
        return bloodBank;
    }

    public void setBloodBank(BloodBank bloodBank) {
        this.bloodBank = bloodBank;
    }

    public Boolean getCertificationIssued() {
        return certificationIssued;
    }

    public void setCertificationIssued(Boolean certificationIssued) {
        this.certificationIssued = certificationIssued;
    }
}
