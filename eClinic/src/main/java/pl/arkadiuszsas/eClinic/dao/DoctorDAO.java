package pl.arkadiuszsas.eClinic.dao;

import java.util.List;

import pl.arkadiuszsas.eClinic.entity.Doctor;

public interface DoctorDAO {

	public List<Doctor> getDoctors();

	public void saveDoctor(Doctor addedDoctor);

	public Doctor getDoctor(int doctorId);

	public void deleteDoctor(int doctorId);	
}
