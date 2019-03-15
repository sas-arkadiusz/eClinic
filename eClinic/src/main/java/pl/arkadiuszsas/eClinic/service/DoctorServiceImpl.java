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

}
