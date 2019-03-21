package pl.arkadiuszsas.eClinic.dao;

import java.util.List;

import pl.arkadiuszsas.eClinic.entity.Patient;

public interface PatientDAO {

	public List<Patient> getPatients();

	public void savePatient(Patient addedPatient);

	public Patient getPatient(int patientId);
}
