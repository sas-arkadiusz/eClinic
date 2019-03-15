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
	
	
	
}
