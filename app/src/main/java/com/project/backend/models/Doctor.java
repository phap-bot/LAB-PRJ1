package com.project.backend.models;

import jakarta.persistence.*;
import java.util.List;

@Entity @Table(name="doctors")
public class Doctor {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private String specialization;
  private String licenseNumber;

  @ElementCollection
  private List<String> availableTimes;

  public Doctor() {}
  // getters/setters
  public Long getId(){return id;} public void setId(Long id){this.id=id;}
  public String getName(){return name;} public void setName(String n){this.name=n;}
  public String getSpecialization(){return specialization;} public void setSpecialization(String s){this.specialization=s;}
  public String getLicenseNumber(){return licenseNumber;} public void setLicenseNumber(String l){this.licenseNumber=l;}
  public List<String> getAvailableTimes(){return availableTimes;} public void setAvailableTimes(List<String> a){this.availableTimes=a;}
}
