package pl.arkadiuszsas.eClinic.entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name = "doctor")
public class Doctor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "doctor_id")
	private int doctorId;
	
	@NotNull
	@Size(max = 25)
	@Column(name = "first_name")
	private String firstName;
	
	@NotNull
	@Size(max = 50)
	@Column(name = "last_name")
	private String lastName;
	
	@NotNull
	@Column(name = "date_of_birth")
	private Date dateOfBirth;
	
	@Size(max = 254)
	@Column(name = "email_address")
	private String emailAddress;
	
	@Size(max = 15)
	@Column(name = "phone_number")
	private String phoneNumber;
	
	@NotNull
	@Size(max = 50)
	@Column(name = "street")
	private String streetName;
	
	@NotNull
	@Size(max = 50)
	@Column(name = "city")
	private String cityName;
	
	@NotNull
	@Size(max = 10)
	@Column(name = "postal_code")
	private String postalCode;
	
	@NotNull
	@Column(name = "salary")
	private int salary;
	
	@OneToMany(mappedBy = "doctorId")
	private List<Patient> doctorsPatients;
	
	public Doctor() {
		
	}

	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	public List<Patient> getDoctorsPatients() {
		return doctorsPatients;
	}

	public void setDoctorsPatients(List<Patient> doctorsPatients) {
		this.doctorsPatients = doctorsPatients;
	}

	@Override
	public String toString() {
		return "doctorId";
	}
	
	
	
}
