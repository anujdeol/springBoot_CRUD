package com.anuj.asn3.controller;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anuj.asn3.model.Patient;
import com.anuj.asn3.services.impl.PatientServicesImpl;

@RestController
@RequestMapping("/patients")
public class PatientController {

	@Autowired
	private PatientServicesImpl patientService;

	@Autowired
	public PatientController(PatientServicesImpl patientService) {
		this.patientService = patientService;
	}

	@GetMapping
	public HashSet<Patient> findAllPatients() {
		return patientService.findAllPatients();
	}
	
    @PatchMapping("/{id}")
    public Patient updatePatient(@PathVariable long id, @RequestBody Patient patient) {
        return patientService.updatePatient(id, patient);
    }

	@GetMapping("/{id}")
	public Patient findPatientByID(@PathVariable long id) {
		return patientService.findPatientByID(id);
	}

	@PostMapping
	public Patient addPatient(@RequestBody Patient patient) {
		return patientService.addPatient(patient);
	}

	@DeleteMapping("/{id}")
	public void deletePatientById(@PathVariable long id) {
		patientService.deletePatientById(id);
	}
}
