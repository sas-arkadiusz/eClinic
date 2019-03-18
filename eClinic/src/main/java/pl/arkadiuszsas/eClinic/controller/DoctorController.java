package pl.arkadiuszsas.eClinic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.arkadiuszsas.eClinic.entity.Doctor;
import pl.arkadiuszsas.eClinic.service.DoctorService;

@Controller
@RequestMapping("/doctor")
public class DoctorController {

	@Autowired
	private DoctorService doctorService; // injected doctor service
	
	@GetMapping("/showAllDoctors")
	public String listDoctor(Model theModel) {
		
		List<Doctor> allDoctors = doctorService.getDoctors();
		
		theModel.addAttribute("allDoctors", allDoctors);
		
		return "show-doctors";
	}
	
	
	@GetMapping("/showAddDoctorForm")
	public String showAddDoctorForm(Model theModel) {
		
		return "add-doctor-form";
	}
	
}
