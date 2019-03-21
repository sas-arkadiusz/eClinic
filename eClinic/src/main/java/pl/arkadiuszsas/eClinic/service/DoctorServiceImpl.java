package pl.arkadiuszsas.eClinic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.arkadiuszsas.eClinic.dao.DoctorDAO;
import pl.arkadiuszsas.eClinic.entity.Doctor;

@Service
public class DoctorServiceImpl implements DoctorService {
	
	@Autowired
	private DoctorDAO doctorDAO; // injected doctorDAO
	
	@Override
	@Transactional
	public List<Doctor> getDoctors() {
		
		return doctorDAO.getDoctors();
	}

	@Override
	@Transactional
	public void saveDoctor(Doctor addedDoctor) {
		
		doctorDAO.saveDoctor(addedDoctor);
	}

	@Override
	@Transactional
	public Doctor getDoctor(int doctorId) {

		return doctorDAO.getDoctor(doctorId);
	}

	@Override
	@Transactional
	public void deleteDoctor(int doctorId) {
		
		doctorDAO.deleteDoctor(doctorId);		
	}

	@Override
	@Transactional
	public List<Doctor> searchDoctors(String doctorsLastName) {
		
		return doctorDAO.searchDoctors(doctorsLastName);
	}

}
