package pl.arkadiuszsas.eClinic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

		// necessary to display all doctors
		List<Doctor> allDoctorsList = doctorService.getDoctors();
		theModel.addAttribute("allDoctorsList", allDoctorsList);

		return "add-patient-form";
	}

	@PostMapping("/saveNewPatient")
	public String saveNewPatient(@ModelAttribute("addedPatient") Patient addedPatient, Model theModel) {

		patientService.savePatient(addedPatient);

		return "redirect:/patient/showAllPatients";
	}

	@GetMapping("/updatePatientForm")
	public String updatePatientForm(@RequestParam("updatedPatientId") int updatedPatientId, Model theModel) {

		Patient updatedPatient = patientService.getPatient(updatedPatientId);

		// assign the current Doctor to the Patient
		Doctor updatedDoctor = doctorService.getDoctor(updatedPatient.getDoctorId().getDoctorId());
		updatedPatient.setDoctorId(updatedDoctor);

		// added attribute name has to be equal to modelAttribute in add-doctor-form.jsp
		theModel.addAttribute("addedPatient", updatedPatient);

		// necessary to display all doctors
		List<Doctor> allDoctorsList = doctorService.getDoctors();
		theModel.addAttribute("allDoctorsList", allDoctorsList);

		return "add-patient-form";
	}
	
	@GetMapping("/deletePatient")
	public String deletePatient(@RequestParam("deletedPatientId") int deletedPatientId) {
		
		patientService.deletePatient(deletedPatientId);
		
		return "redirect:/patient/showAllPatients";
	}
	
	@GetMapping("/searchPatient")
	public String searchPatients(@RequestParam("requestedPatientLastName") String patientsLastName, Model theModel) {
		
		List<Patient> searchedPatientsList = patientService.searchPatients(patientsLastName);
		
		theModel.addAttribute("allPatientsList", searchedPatientsList);
		
		return "show-patients";
	}

}
