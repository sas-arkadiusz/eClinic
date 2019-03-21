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

@Controller
@RequestMapping("/doctor")
public class DoctorController {

	@Autowired
	private DoctorService doctorService; // injected doctorService to handle Doctor objects
	
	@GetMapping("/showAllDoctors")
	public String listDoctor(Model theModel) {
		
		List<Doctor> allDoctors = doctorService.getDoctors();
		
		theModel.addAttribute("allDoctors", allDoctors);
		
		return "show-doctors";
	}
	
	
	@GetMapping("/addDoctorForm")
	public String addDoctorForm(Model theModel) {
		
		Doctor addDoctor = new Doctor();
		
		theModel.addAttribute("addDoctor", addDoctor);
		
		return "add-doctor-form";
	}
	
	@PostMapping("/saveNewDoctor")
	public String saveNewDoctor(@ModelAttribute("addDoctor") Doctor addedDoctor) {
				
		doctorService.saveDoctor(addedDoctor);
		
		return "redirect:/doctor/showAllDoctors";
	}
	
	@GetMapping("/updateDoctorForm")
	public String updateDoctorForm(@RequestParam("updatedDoctorId") int updatedDoctorId, Model theModel) {
		
		Doctor updatedDoctor = doctorService.getDoctor(updatedDoctorId);
		
		// added attribute name has to be equal to modelAttribute in add-doctor-form.jsp
		theModel.addAttribute("addDoctor", updatedDoctor);
		
		return "add-doctor-form";
	}
	
	@GetMapping("/deleteDoctor")
	public String deleteDoctor(@RequestParam("deletedDoctorId") int deletedDoctorId) {
		
		doctorService.deleteDoctor(deletedDoctorId);
		
		return "redirect:/doctor/showAllDoctors";
	}
	
}
