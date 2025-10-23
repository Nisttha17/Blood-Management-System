package com.example.bloodbank.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "patients")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long patientId;  // Patient_Id (PK)

    private String name;

    private int age;

    private String gender;

    private String bloodGroup;

    private String disease;

    private String contactNumber;

    private String address;

    private LocalDate admissionDate;

    // Many patients can belong to one hospital
    @ManyToOne
    @JoinColumn(name = "hospital_id", nullable = false)  // Hospital_Id (FK)
    private Hospital hospital;

    // Default constructor
    public Patient() {
    }

    // Parameterized constructor
    public Patient(String name, int age, String gender, String bloodGroup, String disease,
                   String contactNumber, String address, LocalDate admissionDate, Hospital hospital) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.bloodGroup = bloodGroup;
        this.disease = disease;
        this.contactNumber = contactNumber;
        this.address = address;
        this.admissionDate = admissionDate;
        this.hospital = hospital;
    }

    // Getters and Setters
    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(LocalDate admissionDate) {
        this.admissionDate = admissionDate;
    }

    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }
}
