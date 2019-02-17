package gr.hua.dit.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import gr.hua.dit.entity.Publisher;
import gr.hua.dit.entity.Student;
import gr.hua.dit.entity.Teacher;

@Repository
public class PublisherDAOImpl implements PublisherDAO {

	@Autowired
	private SessionFactory sessionFactory;

	
	@Override
	public List<Publisher> getPublishers() {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// create a query
		Query<Publisher> query = currentSession.createQuery("from Publisher", Publisher.class);

		// execute the query and get the results list
		List<Publisher> publishers = query.getResultList();

		// return the results
		return publishers;
	}
	
	@Override
	public Publisher getPublisher(int id) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//get and return Publisher
		Publisher publisher = currentSession.get(Publisher.class, id);
		return publisher;
	}
	
	@Override
	   public void savePublisher(Publisher publisher) {
	           // get current hibernate session
	           Session currentSession = sessionFactory.getCurrentSession();
	           // save the textbook
		
			currentSession.save(publisher);
	           
	   }
	
	@Override
	public void deletePublisher(int id) {
		
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// find the textbook
		Publisher publisher = currentSession.get(Publisher.class, id);
		
		// delete textbook
		currentSession.delete(publisher);
	}
	
	@Override
	   public void updatePublisher(Publisher publisher) {
	           // get current hibernate session
	           Session currentSession = sessionFactory.getCurrentSession();
	           
			System.out.println(publisher);

			currentSession.update(publisher);
	           
	   }

}
