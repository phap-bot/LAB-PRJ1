package com.project.backend.repo;

import com.project.backend.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    /**
     * Tìm bệnh nhân theo email
     * @param email địa chỉ email của bệnh nhân
     * @return Optional<Patient>
     */
    Optional<Patient> findByEmail(String email);

    /**
     * Tìm bệnh nhân theo số điện thoại
     * @param phoneNumber số điện thoại của bệnh nhân
     * @return Optional<Patient>
     */
    Optional<Patient> findByPhoneNumber(String phoneNumber);
}
