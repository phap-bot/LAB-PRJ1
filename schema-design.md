# MySQL Schema
Tables: users(id, username, password, role), patients(id, user_id, ...),
doctors(id, user_id, specialization, license_number),
appointments(id, patient_id, doctor_id, appointment_date, status),
prescriptions(id, appointment_id, medicine_name, dosage, instructions),
audit_log(id, user_id, action, timestamp).
