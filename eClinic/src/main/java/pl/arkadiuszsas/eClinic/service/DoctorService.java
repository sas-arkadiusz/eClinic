package pl.arkadiuszsas.eClinic.service;

import java.util.List;

import pl.arkadiuszsas.eClinic.entity.Doctor;

public interface DoctorService {

	public List<Doctor> getDoctors();

	public void saveDoctor(Doctor addedDoctor);

	public Doctor getDoctor(int doctorId);
}
