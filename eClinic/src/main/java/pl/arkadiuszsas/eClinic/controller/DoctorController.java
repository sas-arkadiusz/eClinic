package pl.arkadiuszsas.eClinic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.arkadiuszsas.eClinic.dao.DoctorDAO;
import pl.arkadiuszsas.eClinic.entity.Doctor;

@Controller
@RequestMapping("/doctor")
public class DoctorController {

	@Autowired
	private DoctorDAO doctorDAO;
	
	@GetMapping("/showAllDoctors")
	public String listDoctor(Model theModel) {
		
		List<Doctor> allDoctors = doctorDAO.getDoctors();
		
		theModel.addAttribute("allDoctors", allDoctors);
		
		return "show-doctors";
	}
	
}
