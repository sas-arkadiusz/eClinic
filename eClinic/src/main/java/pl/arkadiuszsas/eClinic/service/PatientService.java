package pl.arkadiuszsas.eClinic.service;

import java.util.List;

import pl.arkadiuszsas.eClinic.entity.Patient;

public interface PatientService {
	
	public List<Patient> getPatients();

	public void savePatient(Patient addedPatient);

	public Patient getPatient(int patientId);
}
