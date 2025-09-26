package com.project.backend.models;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "doctors")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;   // Primary Key

    private String name;
    private String specialization;
    private String licenseNumber;

    @ElementCollection
    private List<String> availableTimes;  // required field

    // Constructors
    public Doctor() {}

    public Doctor(String name, String specialization, String licenseNumber, List<String> availableTimes) {
        this.name = name;
        this.specialization = specialization;
        this.licenseNumber = licenseNumber;
        this.availableTimes = availableTimes;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getSpecialization() { return specialization; }
    public void setSpecialization(String specialization) { this.specialization = specialization; }

    public String getLicenseNumber() { return licenseNumber; }
    public void setLicenseNumber(String licenseNumber) { this.licenseNumber = licenseNumber; }

    public List<String> getAvailableTimes() { return availableTimes; }
    public void setAvailableTimes(List<String> availableTimes) { this.availableTimes = availableTimes; }
}
