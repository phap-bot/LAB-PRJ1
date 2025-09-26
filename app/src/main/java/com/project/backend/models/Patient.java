package com.project.backend.models;

import jakarta.persistence.*;

@Entity @Table(name="patients")
public class Patient {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  public Patient() {}
  public Long getId(){return id;} public void setId(Long id){this.id=id;}
  public String getName(){return name;} public void setName(String n){this.name=n;}
}
