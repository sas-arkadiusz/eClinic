package pl.arkadiuszsas.eClinic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.arkadiuszsas.eClinic.entity.Doctor;
import pl.arkadiuszsas.eClinic.entity.Patient;
import pl.arkadiuszsas.eClinic.service.DoctorService;
import pl.arkadiuszsas.eClinic.service.PatientService;

@Controller
@RequestMapping("/patient")
public class PatientController {

	@Autowired
	private PatientService patientService; // injected patientService to handle Patient objects

	@Autowired
	private DoctorService doctorService; // injected doctorService to handle Doctor objects

	@GetMapping("/showAllPatients")
	public String listPatient(Model theModel) {

		List<Patient> allPatientsList = patientService.getPatients();

		theModel.addAttribute("allPatientsList", allPatientsList);

		return "show-patients";
	}

	@GetMapping("/addPatientForm")
	public String showAddPatientForm(Model theModel) {
		
		Patient addedPatient = new Patient();
		theModel.addAttribute("addedPatient", addedPatient);
				
		List<Doctor> allDoctorsList = doctorService.getDoctors();
		theModel.addAttribute("allDoctorsList", allDoctorsList);

		return "add-patient-form";
	}

	@PostMapping("/saveNewPatient")
	public String saveNewPatient(@ModelAttribute("addedPatient") Patient addedPatient, Model theModel) {

		patientService.savePatient(addedPatient);

		return "redirect:/patient/showAllPatients";
	}

}
