package com.example.bloodbank.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "report")
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "report_id")
    private Long reportId;

    // Foreign key to Donor
    @ManyToOne
    @JoinColumn(name = "donor_id", nullable = false)
    private Donor donor;

    // Foreign key to BloodCamp
    @ManyToOne
    @JoinColumn(name = "blood_camp_id", nullable = false)
    private BloodCamp bloodCamp;

    @Column(name = "health_status", nullable = false)
    private String healthStatus;

    @Column(name = "blood_test_result", nullable = false)
    private String bloodTestResult;

    @Column(name = "donation_date", nullable = false)
    private LocalDate donationDate;

    @Column(name = "remarks")
    private String remarks;

    // ===== Getters & Setters =====

    public Long getReportId() {
        return reportId;
    }

    public void setReportId(Long reportId) {
        this.reportId = reportId;
    }

    public Donor getDonor() {
        return donor;
    }

    public void setDonor(Donor donor) {
        this.donor = donor;
    }

    public BloodCamp getBloodCamp() {
        return bloodCamp;
    }

    public void setBloodCamp(BloodCamp bloodCamp) {
        this.bloodCamp = bloodCamp;
    }

    public String getHealthStatus() {
        return healthStatus;
    }

    public void setHealthStatus(String healthStatus) {
        this.healthStatus = healthStatus;
    }

    public String getBloodTestResult() {
        return bloodTestResult;
    }

    public void setBloodTestResult(String bloodTestResult) {
        this.bloodTestResult = bloodTestResult;
    }

    public LocalDate getDonationDate() {
        return donationDate;
    }

    public void setDonationDate(LocalDate donationDate) {
        this.donationDate = donationDate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
