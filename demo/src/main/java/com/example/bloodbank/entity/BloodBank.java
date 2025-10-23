package com.example.bloodbank.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Table;

@Entity
@Table(name = "bloodbank")
public class BloodBank {

    @Id
    @Column(name = "bloodbank_id")
    private long bloodBankId;

    @Column(name = "name")
    private String name;

    @Column(name = "location")
    private String location;

    @Column(name = "contact_no")
    private String contactNo;

    @Column(name = "incharge_name")
    private String inchargeName;

    @Column(name = "associated_hospital_id")
    private long associatedHospitalId;

    // Default constructor required by JPA
    public BloodBank() {
    }

    // Parameterized constructor
    public BloodBank(long bloodBankId, String name, String location, String contactNo, String inchargeName, long associatedHospitalId) {
        this.bloodBankId = bloodBankId;
        this.name = name;
        this.location = location;
        this.contactNo = contactNo;
        this.inchargeName = inchargeName;
        this.associatedHospitalId = associatedHospitalId;
    }

    // Getters and Setters
    public long getBloodBankId() {
        return bloodBankId;
    }

    public void setBloodBankId(long bloodBankId) {
        this.bloodBankId = bloodBankId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getInchargeName() {
        return inchargeName;
    }

    public void setInchargeName(String inchargeName) {
        this.inchargeName = inchargeName;
    }

    public long getAssociatedHospitalId() {
        return associatedHospitalId;
    }

    public void setAssociatedHospitalId(long associatedHospitalId) {
        this.associatedHospitalId = associatedHospitalId;
    }
}
