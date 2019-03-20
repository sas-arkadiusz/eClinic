package pl.arkadiuszsas.eClinic.converter;

import org.springframework.core.convert.converter.Converter;

import pl.arkadiuszsas.eClinic.entity.Doctor;

final class StringToDoctorConverter implements Converter<String, Doctor>{
	public Doctor convert(String source) {		
		
		Doctor theDoctor = new Doctor();
		theDoctor.setDoctorId(Integer.parseInt(source));
		
		return theDoctor;
	}
}
