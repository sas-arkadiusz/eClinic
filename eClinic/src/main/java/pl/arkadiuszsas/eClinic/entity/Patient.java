package pl.arkadiuszsas.eClinic.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "patient")
public class Patient {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "patient_id")
	private int patientId;

	@ManyToOne
	@JoinColumn(name = "doctor_id")
	private int doctorId;

	@NotNull
	@Column(name = "file_id", unique = true)
	private int fileId;

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
	@Column(name = "first_visit_date")
	private Date firstVisitDate;

	@NotNull
	@Column(name = "last_visit_date")
	private Date lastVisitDate;

	@NotNull
	@Column(name = "is_insurance")
	private boolean isInsurance;

	public Patient() {
		
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	public int getFileId() {
		return fileId;
	}

	public void setFileId(int fileId) {
		this.fileId = fileId;
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

	public Date getFirstVisitDate() {
		return firstVisitDate;
	}

	public void setFirstVisitDate(Date firstVisitDate) {
		this.firstVisitDate = firstVisitDate;
	}

	public Date getLastVisitDate() {
		return lastVisitDate;
	}

	public void setLastVisitDate(Date lastVisitDate) {
		this.lastVisitDate = lastVisitDate;
	}

	public boolean isInsurance() {
		return isInsurance;
	}

	public void setInsurance(boolean isInsurance) {
		this.isInsurance = isInsurance;
	}

	@Override
	public String toString() {
		return "Patient [patientId=" + patientId + ", doctorId=" + doctorId + ", fileId=" + fileId + ", firstName="
				+ firstName + ", lastName=" + lastName + ", dateOfBirth=" + dateOfBirth + ", emailAddress="
				+ emailAddress + ", phoneNumber=" + phoneNumber + ", streetName=" + streetName + ", cityName="
				+ cityName + ", postalCode=" + postalCode + ", firstVisitDate=" + firstVisitDate + ", lastVisitDate="
				+ lastVisitDate + ", isInsurance=" + isInsurance + "]";
	}
		
}
