package com.project.backend.models;

public class Doctor {
    private int doctorId;
    private String name;
    private String specialization;
    private String licenseNumber;

    // Constructor
    public Doctor(int doctorId, String name, String specialization, String licenseNumber) {
        this.doctorId = doctorId;
        this.name = name;
        this.specialization = specialization;
        this.licenseNumber = licenseNumber;
    }

    // Default constructor
    public Doctor() {}

    // Getters and Setters
    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "doctorId=" + doctorId +
                ", name='" + name + '\'' +
                ", specialization='" + specialization + '\'' +
                ", licenseNumber='" + licenseNumber + '\'' +
                '}';
    }
}
