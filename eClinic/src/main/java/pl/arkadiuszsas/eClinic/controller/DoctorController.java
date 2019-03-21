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
	public String showAddDoctorForm(Model theModel) {
		
		Doctor addDoctor = new Doctor();
		
		theModel.addAttribute("addDoctor", addDoctor);
		
		return "add-doctor-form";
	}
	
	@PostMapping("/saveNewDoctor")
	public String saveNewDoctor(@ModelAttribute("addDoctor") Doctor addedDoctor) {
		
		doctorService.saveDoctor(addedDoctor);
		
		return "redirect:/doctor/showAllDoctors";
	}
	
}
