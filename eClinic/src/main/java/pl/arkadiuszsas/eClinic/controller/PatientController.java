package pl.arkadiuszsas.eClinic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.arkadiuszsas.eClinic.entity.Patient;
import pl.arkadiuszsas.eClinic.service.PatientService;

@Controller
@RequestMapping("/patient")
public class PatientController {

	@Autowired
	private PatientService patientService; // injected patient service
	
	@GetMapping("/showAllPatients")
	public String listPatient(Model theModel) {
		
		List<Patient> allPatients = patientService.getPatients();
		
		theModel.addAttribute("allPatients", allPatients);
		
		return "show-patients";
	}
	
}
