package com.example.bloodbank.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "donor")
public class Donor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "donor_id")
    private Long donorId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "age", nullable = false)
    private Integer age;

    @Column(name = "gender", nullable = false)
    private String gender;

    @Column(name = "contact_no", nullable = false, length = 15)
    private String contactNo;

    @Column(name = "blood_group", nullable = false, length = 5)
    private String bloodGroup;

    @Column(name = "address")
    private String address;

    @Column(name = "last_donation_date")
    private LocalDate lastDonationDate;

    @Column(name = "donor_type")
    private String donorType;

    @Column(name = "eligibility_status")
    private String eligibilityStatus;

    @Column(name = "certification_status")
    private String certificationStatus;

    // ===== Constructors =====
    public Donor() {}

    public Donor(String name,
                 Integer age,
                 String gender,
                 String contactNo,
                 String bloodGroup,
                 String address,
                 LocalDate lastDonationDate,
                 String donorType,
                 String eligibilityStatus,
                 String certificationStatus) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.contactNo = contactNo;
        this.bloodGroup = bloodGroup;
        this.address = address;
        this.lastDonationDate = lastDonationDate;
        this.donorType = donorType;
        this.eligibilityStatus = eligibilityStatus;
        this.certificationStatus = certificationStatus;
    }

    // ===== Getters & Setters =====
    public Long getDonorId() { return donorId; }
    public void setDonorId(Long donorId) { this.donorId = donorId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Integer getAge() { return age; }
    public void setAge(Integer age) { this.age = age; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public String getContactNo() { return contactNo; }
    public void setContactNo(String contactNo) { this.contactNo = contactNo; }

    public String getBloodGroup() { return bloodGroup; }
    public void setBloodGroup(String bloodGroup) { this.bloodGroup = bloodGroup; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public LocalDate getLastDonationDate() { return lastDonationDate; }
    public void setLastDonationDate(LocalDate lastDonationDate) { this.lastDonationDate = lastDonationDate; }

    public String getDonorType() { return donorType; }
    public void setDonorType(String donorType) { this.donorType = donorType; }

    public String getEligibilityStatus() { return eligibilityStatus; }
    public void setEligibilityStatus(String eligibilityStatus) { this.eligibilityStatus = eligibilityStatus; }

    public String getCertificationStatus() { return certificationStatus; }
    public void setCertificationStatus(String certificationStatus) { this.certificationStatus = certificationStatus; }
}
