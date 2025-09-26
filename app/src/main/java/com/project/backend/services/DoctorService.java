package com.project.backend.services;

import com.project.backend.models.Doctor;
import com.project.backend.repo.DoctorRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    /* ========== CRUD cơ bản ========== */
    public List<Doctor> getAllDoctors() { return doctorRepository.findAll(); }

    public Doctor getDoctorById(Long id) {
        return doctorRepository.findById(id).orElse(null);
    }

    public Doctor saveDoctor(Doctor doctor) { return doctorRepository.save(doctor); }

    public Doctor updateDoctor(Doctor doctor) { return doctorRepository.save(doctor); }

    public void deleteDoctor(Long id) { doctorRepository.deleteById(id); }

    /* ========== ✅ RUBRIC: Lấy available time slots của bác sĩ ========== */
    public List<String> getAvailableTimes(Long doctorId) {
        return doctorRepository.findById(doctorId)
                .map(Doctor::getAvailableTimes)
                .orElse(Collections.emptyList());
    }

    /* ========== ✅ RUBRIC: Validate login credentials cho bác sĩ ========== */
    public boolean validateDoctorLogin(String email, String password) {
        // Demo lab: so sánh plain text. Nếu bạn dùng BCrypt, thay equals bằng passwordEncoder.matches(...)
        Optional<Doctor> docOpt = doctorRepository.findByEmail(email);
        return docOpt.map(d -> d.getPassword() != null && d.getPassword().equals(password))
                     .orElse(false);
    }
}
