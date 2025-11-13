package com.klef.dev.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "patient_table")
public class Patient {
    @Id
    @Column(name = "patient_id")
    private int id;

    @Column(name = "patient_name", nullable = false, length = 50)
    private String name;

    @Column(name = "patient_gender", nullable = false, length = 10)
    private String gender; // FEMALE or MALE

    @Column(name = "patient_department", nullable = false, length = 20)
    private String department; // e.g., Cardiology, Neurology

    @Column(name = "patient_treatment_plan", nullable = false, length = 50)
    private String treatmentPlan; // e.g., Surgery, Medication

    @Column(name = "patient_admission_year", nullable = false)
    private String admissionYear; // 2021, 2022, etc.

    @Column(name = "patient_room_number", nullable = false, length = 10)
    private String roomNumber; // Room number in hospital

    @Column(name = "patient_email", nullable = false, unique = true, length = 50)
    private String email;

    @Column(name = "patient_password", nullable = false, length = 50)
    private String password;

    @Column(name = "patient_contact", nullable = false, unique = true, length = 20)
    private String contact;

    // Getters and Setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }

    public String getTreatmentPlan() {
        return treatmentPlan;
    }
    public void setTreatmentPlan(String treatmentPlan) {
        this.treatmentPlan = treatmentPlan;
    }

    public String getAdmissionYear() {
        return admissionYear;
    }
    public void setAdmissionYear(String admissionYear) {
        this.admissionYear = admissionYear;
    }

    public String getRoomNumber() {
        return roomNumber;
    }
    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getContact() {
        return contact;
    }
    public void setContact(String contact) {
        this.contact = contact;
    }

    @Override
    public String toString() {
        return "Patient [id=" + id + ", name=" + name + ", gender=" + gender + ", department=" + department
                + ", treatmentPlan=" + treatmentPlan + ", admissionYear=" + admissionYear + ", roomNumber=" + roomNumber
                + ", email=" + email + ", password=" + password + ", contact=" + contact + "]";
    }
}