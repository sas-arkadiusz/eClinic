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

		Query<Patient> hqlQuery = currentHibernateSession.createQuery("from Patient order by lastName", Patient.class);

		// get the result of the query list
		List<Patient> allPatients = hqlQuery.getResultList();

		return allPatients;
	}

	@Override
	public void savePatient(Patient addedPatient) {

		// get the current hibernate session
		Session currentHibernateSession = sessionFactory.getCurrentSession();

		// find and set proper patientId
		if (addedPatient.getPatientId() == 0) {
			/*Query hqlQuery = currentHibernateSession.createQuery("select max(patientId) from Patient", Integer.class);
			Integer lastPatientId = (Integer) hqlQuery.getSingleResult();
			addedPatient.setPatientId(lastPatientId + 1);*/

			Query hqlQuery = currentHibernateSession.createQuery("select max(fileId) from Patient", Integer.class);
			Integer lastFileId = (Integer) hqlQuery.getSingleResult();
			addedPatient.setFileId(lastFileId + 1);
		}
		else {
			Query hqlQuery = currentHibernateSession.createQuery("select fileId from Patient where patientId = " + addedPatient.getPatientId(), Integer.class);
			Integer currentPatientFileId = (Integer) hqlQuery.getSingleResult();
			addedPatient.setFileId(currentPatientFileId);
		}
		// save the addedPatient
		currentHibernateSession.saveOrUpdate(addedPatient);
	}

	@Override
	public Patient getPatient(int patientId) {

		// get the current hibernate session
		Session currentHibernateSession = sessionFactory.getCurrentSession();

		// retrieve the requested Patient
		Patient requestedPatient = currentHibernateSession.get(Patient.class, patientId);

		return requestedPatient;
	}

	@Override
	public void deletePatient(int patientId) {
		
		// get the current hibernate session
		Session currentHibernateSession = sessionFactory.getCurrentSession();
		
		// delete the Patient
		Query hqlQuery = currentHibernateSession.createQuery("delete from Patient where patientId = :deletedPatientId");
		
		hqlQuery.setParameter("deletedPatientId", patientId);
		
		hqlQuery.executeUpdate();
		
	}

	@Override
	public List<Patient> searchPatients(String patientsLastName) {
		
		// get the current hibernate session
		Session currentHibernateSession = sessionFactory.getCurrentSession();
		
		Query hqlQuery = null;
		
		if(patientsLastName != null && patientsLastName.trim().length() > 0) {
			
			hqlQuery = currentHibernateSession.createQuery(
					"from Patient where lower(lastName) like :patientsLastName", Patient.class);
			hqlQuery.setParameter("patientsLastName", patientsLastName.toLowerCase());
		}
		else {
			hqlQuery = currentHibernateSession.createQuery("from Patient", Patient.class);
		}
		
		List<Patient> requestedPatientsList = hqlQuery.getResultList();
		
		return requestedPatientsList;
	}

}
