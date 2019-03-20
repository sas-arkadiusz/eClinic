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
	private PatientService patientService; // injected patient service

	@Autowired
	private DoctorService doctorService; // injected doctor service

	@GetMapping("/showAllPatients")
	public String listPatient(Model theModel) {

		List<Patient> allPatients = patientService.getPatients();

		theModel.addAttribute("allPatients", allPatients);

		return "show-patients";
	}

	@GetMapping("/showAddPatientForm")
	public String showAddPatientForm(Model theModel) {
		
		Patient addPatient = new Patient();
		theModel.addAttribute("addPatient", addPatient);
		
		List<Doctor> allDoctors = doctorService.getDoctors();
		theModel.addAttribute("allDoctors", allDoctors);
		
		int chosenDoctorId = 0;
		theModel.addAttribute("chosenDoctorId", chosenDoctorId);
		theModel.addAttribute("getChosenDoctorId", 2);

		return "add-patient-form";
	}

	@PostMapping("/saveNewPatient")
	public String saveNewPatient(@ModelAttribute("addPatient") Patient addedPatient, Model theModel) {

		theModel.addAttribute("getChosenDoctorId", 2);
		patientService.savePatient(addedPatient);

		return "redirect:/patient/showAllPatients";
	}

}
