package com.project.backend.controllers;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/prescriptions")
public class PrescriptionController {
  static class Prescription {
    public Long id; public Long appointmentId; public String medicineName; public String dosage; public String instructions;
  }
  private final Map<Long, Prescription> mem = new HashMap<>();

  @GetMapping public Collection<Prescription> all(){ return mem.values(); }
  @GetMapping("/{id}") public Prescription one(@PathVariable Long id){ return mem.get(id); }
  @PostMapping public Prescription create(@RequestBody Prescription p){ mem.put(p.id, p); return p; }
  @PutMapping("/{id}") public Prescription update(@PathVariable Long id, @RequestBody Prescription p){ p.id=id; mem.put(id,p); return p; }
  @DeleteMapping("/{id}") public void delete(@PathVariable Long id){ mem.remove(id); }
}
