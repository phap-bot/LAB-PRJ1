package com.project.backend.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity @Table(name="appointments")
public class Appointment {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name="patient_id", nullable=false)
  private Patient patient;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name="doctor_id", nullable=false)
  private Doctor doctor;

  @Column(name="appointment_date", nullable=false)
  private LocalDateTime appointmentDate;

  @Column(length=20, nullable=false)
  private String status;

  public Appointment() {}
  // getters/setters...
  public Long getId(){return id;} public void setId(Long id){this.id=id;}
  public Patient getPatient(){return patient;} public void setPatient(Patient p){this.patient=p;}
  public Doctor getDoctor(){return doctor;} public void setDoctor(Doctor d){this.doctor=d;}
  public LocalDateTime getAppointmentDate(){return appointmentDate;}
  public void setAppointmentDate(LocalDateTime dt){this.appointmentDate=dt;}
  public String getStatus(){return status;} public void setStatus(String s){this.status=s;}
}
