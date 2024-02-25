package com.anuj.asn3.services;

import java.util.HashSet;

import com.anuj.asn3.model.Patient;

public interface PatientServices {

	HashSet<Patient> findAllPatients();

    Patient findPatientByID(long id);

    Patient addPatient(Patient patient);

    void deletePatientById(long id);

	Patient updatePatient(long id, Patient updatedPatient);


}
