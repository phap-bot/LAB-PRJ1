# User Stories – Smart Clinic System

This document lists user stories for three roles: **Doctor**, **Patient**, and **Admin**.  
Each story uses the format: *As a [role], I want [goal], so that [benefit].*  
Acceptance criteria are written in Gherkin-style **Given/When/Then**.

---

## Doctor

### D1. View assigned appointments for today
**Story:** As a Doctor, I want to see my appointments for today so that I can plan my consultations.  
**Acceptance Criteria:**
- Given I am logged in as a doctor  
  When I open **Appointments → Today**  
  Then I see a list with patient name, time, reason, and status.

### D2. Update diagnosis & prescribe medication
**Story:** As a Doctor, I want to record diagnosis and add prescriptions so that patient history is complete.  
**Acceptance Criteria:**
- Given I open a patient’s visit  
  When I enter diagnosis, notes, and prescriptions  
  Then the visit is saved and appears in the patient’s history.

### D3. Search patient medical history
**Story:** As a Doctor, I want to search a patient’s past visits so that I can make informed decisions.  
**Acceptance Criteria:**
- Given a patient has previous visits  
  When I search by date range or keyword  
  Then matching visits are listed with links to details.

### D4. Change appointment status
**Story:** As a Doctor, I want to mark an appointment as Completed/No-show/Cancelled so that reporting is accurate.  
**Acceptance Criteria:**
- When I change the status  
  Then the status updates immediately and is visible to staff and the patient.

---

## Patient

### P1. Self-register & log in
**Story:** As a Patient, I want to create an account and log in so that I can book and manage appointments.  
**Acceptance Criteria:**
- When I sign up with email/phone + password  
  Then I receive verification and can log in securely.

### P2. Book an appointment with a doctor
**Story:** As a Patient, I want to choose a doctor, date/time, and reason so that I can schedule a visit.  
**Acceptance Criteria:**
- Given available slots exist  
  When I select a slot and confirm  
  Then the appointment shows as **Scheduled** and I receive a confirmation.

### P3. View prescriptions & visit history
**Story:** As a Patient, I want to see past visits and prescriptions so that I can follow treatment.  
**Acceptance Criteria:**
- When I open **My History**  
  Then I see visits with diagnosis, doctor notes, and downloadable prescriptions (PDF).

### P4. Edit profile & health info
**Story:** As a Patient, I want to update my profile (age, allergies, conditions) so that doctors are informed.  
**Acceptance Criteria:**
- When I save changes  
  Then updates are validated and immediately available to doctors in visits.

---

## Admin

### A1. Manage users (create/disable Doctor/Patient accounts)
**Story:** As an Admin, I want to create, assign roles, and disable users so that access is controlled.  
**Acceptance Criteria:**
- When I create a user  
  Then the user receives an invite and shows under the correct role.
- When I disable a user  
  Then they cannot log in and future appointments are blocked.

### A2. Configure clinic schedule & slots
**Story:** As an Admin, I want to define working hours and slot lengths per doctor so that booking is consistent.  
**Acceptance Criteria:**
- When I set hours (e.g., Mon–Fri 09:00–17:00, 20-min slots)  
  Then patients only see valid, non-overlapping time slots.

### A3. System audit & reports
**Story:** As an Admin, I want audit logs and reports (appointments per day, no-shows, prescriptions) so that I can monitor operations.  
**Acceptance Criteria:**
- When I generate a report by date range  
  Then a CSV/PDF is produced with totals and breakdowns.

### A4. Role-based access control (RBAC)
**Story:** As an Admin, I want role-based permissions so that each user only sees what they should.  
**Acceptance Criteria:**
- Doctors cannot access Admin screens.  
- Patients cannot edit other users’ data.  
- Admins can access all configuration screens.

---

## Issue Mapping (optional but recommended)
Create GitHub Issues for each story with labels:
- Labels: `role:doctor`, `role:patient`, `role:admin`, `type:story`
- Milestone: `MVP`

Example:
- `#1 D1 – View today's appointments` (labels: role:doctor, type:story)
- `#2 D2 – Update diagnosis & prescriptions` …
- `#5 P1 – Self-register & log in` …
- `#9 A1 – Manage users` …

Link this file in the first issue as the “master list”.
