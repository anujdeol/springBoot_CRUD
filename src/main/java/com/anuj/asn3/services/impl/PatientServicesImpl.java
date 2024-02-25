package com.anuj.asn3.services.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anuj.asn3.model.Patient;
import com.anuj.asn3.repos.PatientRepo;
import com.anuj.asn3.services.PatientServices;


@Service
public class PatientServicesImpl implements PatientServices {

	@Autowired
	private PatientRepo patientRepo;

	@Override
	public HashSet<Patient> findAllPatients() {
		return new HashSet<>(patientRepo.findAll());
	}

	@Override
	public Patient findPatientByID(long id) {
		return patientRepo.findById(id).orElse(null);
	}

	@Override
	public Patient addPatient(Patient patient) {
		return patientRepo.save(patient);
	}

	@Override
	public void deletePatientById(long id) {
		patientRepo.deleteById(id);
	}
	
	
	
	@Override
    public Patient updatePatient(long id, Patient updatedPatient) {
        Optional<Patient> optionalExistingPatient = patientRepo.findById(id);
        if (optionalExistingPatient.isPresent()) {
            Patient existingPatient = optionalExistingPatient.get();
            existingPatient.setFirstName(updatedPatient.getFirstName());
            existingPatient.setLastName(updatedPatient.getLastName());
            existingPatient.setAge(updatedPatient.getAge());
            existingPatient.setGender(updatedPatient.getGender());
            existingPatient.setBloodGroup(updatedPatient.getBloodGroup());
            existingPatient.setCity(updatedPatient.getCity());
            existingPatient.setPhone(updatedPatient.getPhone());
            return patientRepo.save(existingPatient);
        } else {
            return null; 
        }
    }


}
