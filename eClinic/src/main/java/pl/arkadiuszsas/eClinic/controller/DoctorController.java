package pl.arkadiuszsas.eClinic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/doctor")
public class DoctorController {

	@RequestMapping("/showAllDoctors")
	public String listDoctor(Model theModel) {
		
		return "show-doctors";
	}
	
}
