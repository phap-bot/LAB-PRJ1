# Database Schema Design – Smart Clinic System

## Tables

### 1. Users
- `user_id` INT AUTO_INCREMENT PRIMARY KEY  
- `username` VARCHAR(50) UNIQUE NOT NULL  
- `password` VARCHAR(255) NOT NULL  
- `role` ENUM('admin', 'doctor', 'patient') NOT NULL  
- `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP  

### 2. Patients
- `patient_id` INT AUTO_INCREMENT PRIMARY KEY  
- `user_id` INT NOT NULL (FK → Users.user_id)  
- `full_name` VARCHAR(100)  
- `dob` DATE  
- `gender` ENUM('M','F','Other')  
- `phone` VARCHAR(20)  
- `address` VARCHAR(255)  

### 3. Doctors
- `doctor_id` INT AUTO_INCREMENT PRIMARY KEY  
- `user_id` INT NOT NULL (FK → Users.user_id)  
- `specialization` VARCHAR(100)  
- `license_number` VARCHAR(50)  

### 4. Appointments
- `appointment_id` INT AUTO_INCREMENT PRIMARY KEY  
- `patient_id` INT NOT NULL (FK → Patients.patient_id)  
- `doctor_id` INT NOT NULL (FK → Doctors.doctor_id)  
- `appointment_date` DATETIME NOT NULL  
- `status` ENUM('Scheduled','Completed','Cancelled','No-show') DEFAULT 'Scheduled'  
- `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP  

### 5. Prescriptions
- `prescription_id` INT AUTO_INCREMENT PRIMARY KEY  
- `appointment_id` INT NOT NULL (FK → Appointments.appointment_id)  
- `medicine_name` VARCHAR(100)  
- `dosage` VARCHAR(50)  
- `instructions` TEXT  

### 6. Audit_Log
- `log_id` INT AUTO_INCREMENT PRIMARY KEY  
- `user_id` INT NOT NULL (FK → Users.user_id)  
- `action` VARCHAR(100)  
- `timestamp` TIMESTAMP DEFAULT CURRENT_TIMESTAMP  

---

## ERD (Conceptual)
- **Users** → one-to-one → **Doctors/Patients**  
- **Patients** ↔ **Appointments** ↔ **Doctors**  
- **Appointments** ↔ **Prescriptions**  
- **Users** ↔ **Audit_Log**

