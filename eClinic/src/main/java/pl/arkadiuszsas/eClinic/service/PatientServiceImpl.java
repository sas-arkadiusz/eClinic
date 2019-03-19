package pl.arkadiuszsas.eClinic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.arkadiuszsas.eClinic.dao.PatientDAO;
import pl.arkadiuszsas.eClinic.entity.Patient;

@Service
public class PatientServiceImpl implements PatientService {

	@Autowired
	private PatientDAO patientDAO; // injected patientDAO
	
	@Override
	@Transactional
	public List<Patient> getPatients() {
		
		return patientDAO.getPatients();
	}

	@Override
	@Transactional
	public void savePatient(Patient addedPatient) {
		
		patientDAO.savePatient(addedPatient);
	}

}
