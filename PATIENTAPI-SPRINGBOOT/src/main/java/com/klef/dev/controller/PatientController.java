package com.klef.dev.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.klef.dev.entity.Patient;
import com.klef.dev.service.PatientService;

@RestController
@RequestMapping("/patientapi/")
@CrossOrigin(origins = "*")
public class PatientController {

    @Autowired
    private PatientService patientService;
    
    @GetMapping("/")
    public String home() {
        return "Docker Backend is running";
    }

    @GetMapping("/docker")
    public String docker() {
        return "Docker Full Stack Deployment Demo with Git-Actions";
    }

    // Add Patient
    @PostMapping("/add")
    public ResponseEntity<Patient> addPatient(@RequestBody Patient patient) {
        Patient savedPatient = patientService.addPatient(patient);
        return new ResponseEntity<>(savedPatient, HttpStatus.CREATED);
    }

    // Get all Patients
    @GetMapping("/all")
    public ResponseEntity<List<Patient>> getAllPatients() {
        List<Patient> patients = patientService.getAllPatients();
        return new ResponseEntity<>(patients, HttpStatus.OK);
    }

    // Get Patient by ID
    @GetMapping("/get/{id}")
    public ResponseEntity<?> getPatientById(@PathVariable int id) {
        Patient patient = patientService.getPatientById(id);
        if (patient != null) {
            return new ResponseEntity<>(patient, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Patient with ID " + id + " not found.", HttpStatus.NOT_FOUND);
        }
    }

    // Update Patient
    @PutMapping("/update")
    public ResponseEntity<?> updatePatient(@RequestBody Patient patient) {
        Patient existing = patientService.getPatientById(patient.getId());
        if (existing != null) {
            Patient updatedPatient = patientService.updatePatient(patient);
            return new ResponseEntity<>(updatedPatient, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Cannot update. Patient with ID " + patient.getId() + " not found.", HttpStatus.NOT_FOUND);
        }
    }

    // Delete Patient
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletePatient(@PathVariable int id) {
        Patient existing = patientService.getPatientById(id);
        if (existing != null) {
            patientService.deletePatientById(id);
            return new ResponseEntity<>("Patient with ID " + id + " deleted successfully.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Cannot delete. Patient with ID " + id + " not found.", HttpStatus.NOT_FOUND);
        }
    }
}
