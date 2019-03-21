package pl.arkadiuszsas.eClinic.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.arkadiuszsas.eClinic.entity.Doctor;
import pl.arkadiuszsas.eClinic.entity.Patient;

@Repository
public class DoctorDAOImpl implements DoctorDAO {

	@Autowired
	private SessionFactory sessionFactory; // injected hibernate session factory
	
	@Override
	public List<Doctor> getDoctors() {
		
		// get the current hibernate session
		Session currentHibernateSession = sessionFactory.getCurrentSession(); 
		
		Query<Doctor> hqlQuery = currentHibernateSession.createQuery("from Doctor order by lastName", Doctor.class);
		
		// get the result of the query list
		List<Doctor> allDoctors = hqlQuery.getResultList(); 
		
		return allDoctors;
	}

	@Override
	public void saveDoctor(Doctor addedDoctor) {
		
		// get the current hibernate session
		Session currentHibernateSession = sessionFactory.getCurrentSession();
		
		// save/update the addedDoctor
		currentHibernateSession.saveOrUpdate(addedDoctor);
	}

	@Override
	public Doctor getDoctor(int doctorId) {
		
		// get the current hibernate session
		Session currentHibernateSession = sessionFactory.getCurrentSession();
		
		// retrieve the requested Doctor
		Doctor requestedDoctor = currentHibernateSession.get(Doctor.class, doctorId);

		return requestedDoctor;
	}

}
