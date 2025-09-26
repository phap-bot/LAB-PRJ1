package com.project.backend.services;

import com.project.backend.models.Doctor;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class DoctorService {
  private final Map<Long,Doctor> mem = new HashMap<>();
  public List<Doctor> getAllDoctors(){ return new ArrayList<>(mem.values()); }
  public Doctor getDoctorById(Long id){ return mem.get(id); }
  public Doctor saveDoctor(Doctor d){ mem.put(d.getId(), d); return d; }
  public Doctor updateDoctor(Doctor d){ mem.put(d.getId(), d); return d; }
  public void deleteDoctor(Long id){ mem.remove(id); }
}
