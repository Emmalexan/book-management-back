package gr.hua.dit.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import gr.hua.dit.entity.Secretary;
import gr.hua.dit.entity.Teacher;
import gr.hua.dit.entity.User;

@Repository
public class SecretaryDAOImpl implements SecretaryDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
@Override
	
	public List<Secretary> getSecretaries() {
		// get current hibernate session
				Session currentSession = sessionFactory.getCurrentSession();

				// create a query
				Query<Secretary> query = currentSession.createQuery("from Secretary", Secretary.class);

				// execute the query and get the results list
				List<Secretary> secretaries = query.getResultList();

				// return the results
				return secretaries;
	}
	
	@Override
	public Secretary getSecretary(int id) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//get and return Teacher
		Secretary secretary = currentSession.get(Secretary.class, id);
		return secretary;
	}
	
	@Override
	   public void saveSecretary(Secretary secretary) {
	           // get current hibernate session
	           Session currentSession = sessionFactory.getCurrentSession();
	           // save the textbook
		
			currentSession.save(secretary);
	           
	   }
	
	@Override
	public void deleteSecretary(int id) {
		
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// find the textbook
		Secretary secretary = currentSession.get(Secretary.class, id);
		
		// delete textbook
		currentSession.delete(secretary);
	}
	
	@Override
	public void updateSecretary(Secretary secretary) {
	Session currentSession = sessionFactory.getCurrentSession();
		
		// save the user
		currentSession.update(secretary);
		
	}
}
