package pl.arkadiuszsas.eClinic.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import pl.arkadiuszsas.eClinic.entity.Doctor;
import pl.arkadiuszsas.eClinic.entity.Patient;

@Repository
public class PatientDAOImpl implements PatientDAO {

	@Autowired
	private SessionFactory sessionFactory; // injected hibernate session factory
		
	@Override
	public List<Patient> getPatients() {
		
		// get the current hibernate session
		Session currentHibernateSession = sessionFactory.getCurrentSession();
		
		Query<Patient> hqlQuery = currentHibernateSession.createQuery("from Patient", Patient.class);
		
		// get the result of the query list
		List<Patient> allPatients = hqlQuery.getResultList();
		
		return allPatients;
	}

	@Override
	public void savePatient(Patient addedPatient) {
		
		// get the current hibernate session
		Session currentHibernateSession = sessionFactory.getCurrentSession();
		
		Doctor theDoctor = new Doctor();
		theDoctor.setDoctorId(1);
		
		addedPatient.setDoctorId(theDoctor);
	
		
		Query hqlQuery = currentHibernateSession.createQuery("select max(patientId) from Patient", Integer.class);
		Integer i = (Integer)hqlQuery.getSingleResult();
		
		addedPatient.setPatientId(i + 1);
		
		// problem resolved with int casting, don't forget to refactor
		
		// save the addedPatient
		currentHibernateSession.save(addedPatient);
		
	}

}
