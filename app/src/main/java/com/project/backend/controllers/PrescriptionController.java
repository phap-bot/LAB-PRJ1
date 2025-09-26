package com.project.backend.controllers;

import com.project.backend.models.Prescription;
import com.project.backend.services.PrescriptionService;
import com.project.backend.services.TokenService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/prescriptions")
@Validated
public class PrescriptionController {

    private final PrescriptionService prescriptionService;
    private final TokenService tokenService;

    public PrescriptionController(PrescriptionService prescriptionService, TokenService tokenService) {
        this.prescriptionService = prescriptionService;
        this.tokenService = tokenService;
    }

    @PostMapping("/{token}")
    public ResponseEntity<Prescription> create(
            @PathVariable String token,
            @Valid @RequestBody PrescriptionRequest request
    ) {
        Prescription created = prescriptionService.save(request.toEntity());
        return ResponseEntity
                .created(URI.create("/prescriptions/" + created.getId()))
                .body(created);
    }

    @GetMapping
    public ResponseEntity<List<Prescription>> getAll() {
        return ResponseEntity.ok(prescriptionService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Prescription> getById(@PathVariable Long id) {
        return prescriptionService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}/{token}")
    public ResponseEntity<Prescription> update(
            @PathVariable Long id,
            @PathVariable String token,
            @Valid @RequestBody PrescriptionRequest request
    ) {
        return prescriptionService.update(id, request.toEntity())
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}/{token}")
    public ResponseEntity<Void> delete(@PathVariable Long id, @PathVariable String token) {
        if (prescriptionService.delete(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    /** DTO nội bộ để validate dữ liệu đầu vào */
    public static class PrescriptionRequest {
        @NotNull
        private Long appointmentId;

        @NotBlank
        private String medicineName;

        @NotBlank
        private String dosage;

        @NotBlank
        private String instructions;

        // getters + setters
        public Long getAppointmentId() { return appointmentId; }
        public void setAppointmentId(Long appointmentId) { this.appointmentId = appointmentId; }
        public String getMedicineName() { return medicineName; }
        public void setMedicineName(String medicineName) { this.medicineName = medicineName; }
        public String getDosage() { return dosage; }
        public void setDosage(String dosage) { this.dosage = dosage; }
        public String getInstructions() { return instructions; }
        public void setInstructions(String instructions) { this.instructions = instructions; }

        public Prescription toEntity() {
            Prescription p = new Prescription();
            p.setAppointmentId(appointmentId);
            p.setMedicineName(medicineName);
            p.setDosage(dosage);
            p.setInstructions(instructions);
            return p;
        }
    }
}
