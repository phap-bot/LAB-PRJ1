package com.project.backend.services;

import com.project.backend.models.Appointment;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class AppointmentService {
  private final Map<Long, Appointment> mem = new HashMap<>();
  public List<Appointment> getAllAppointments(){ return new ArrayList<>(mem.values()); }
  public Appointment getAppointmentById(Long id){ return mem.get(id); }
  public Appointment createAppointment(Appointment a){ mem.put(a.getId(), a); return a; }
  public Appointment updateAppointment(Long id, Appointment a){ a.setId(id); mem.put(id,a); return a; }
  public void deleteAppointment(Long id){ mem.remove(id); }
}
