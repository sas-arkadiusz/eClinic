package pl.arkadiuszsas.eClinic.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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

}
