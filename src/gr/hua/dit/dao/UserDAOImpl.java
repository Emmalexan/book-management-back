package gr.hua.dit.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import gr.hua.dit.entity.TextBook;
import gr.hua.dit.entity.User;

@Repository
public class UserDAOImpl implements UserDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<User> getUsers() {
		// get current hibernate session
				Session currentSession = sessionFactory.getCurrentSession();
				
				// create a query
				Query<User> query = currentSession.createQuery("from User", User.class);
				
				
				// execute the query and get the results list
				List<User> users = query.getResultList();
						
				//return the results
				return users;
	}

	@Override
	public void saveUser(User user) {
	Session currentSession = sessionFactory.getCurrentSession();
		
		// save the user
		currentSession.save(user);
		
	}

	@Override
	public User getUser(String username) {
		// get current hibernate session
				Session currentSession = sessionFactory.getCurrentSession();
				
				//get and return user
				User user = currentSession.get(User.class, username);
				return user;
	}

	@Override
	public void deleteUser(String username) {
		// get current hibernate session
				Session currentSession = sessionFactory.getCurrentSession();
				
				// find the user
				User user = currentSession.get(User.class, username);

				
				// delete user
				currentSession.delete(user);
		
	}
	@Override
	public void updateUser(User user) {
	Session currentSession = sessionFactory.getCurrentSession();
		
		// save the user
		currentSession.update(user);
		
	}
}
