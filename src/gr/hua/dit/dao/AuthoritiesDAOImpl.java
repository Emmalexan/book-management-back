package gr.hua.dit.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import gr.hua.dit.entity.Authorities;
import gr.hua.dit.entity.TextBook;
import gr.hua.dit.entity.User;
import gr.hua.dit.service.UserService;

@Repository
public class AuthoritiesDAOImpl implements AuthoritiesDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private UserService userService;

	@Override
	public List<Authorities> getAuthorities() {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// create a query
		Query<Authorities> query = currentSession.createQuery("from Authorities", Authorities.class);

		// execute the query and get the results list
		List<Authorities> authorities = query.getResultList();

		// return the results
		return authorities;
	}
	
	
	@Override
	   public void saveAuthoritie(Authorities authoritie) {
	           // get current hibernate session
	           Session currentSession = sessionFactory.getCurrentSession();
	        
			System.out.println(authoritie);

			currentSession.save(authoritie);
	           
	   }
	
	@Override
	public Authorities getAuthoritie(String authority) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//get and return Textbook
		Authorities authoritie = currentSession.get(Authorities.class, authority);
		return authoritie;
	}
	
	@Override
	public Authorities getAuthoritieId(int id) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//get and return Textbook
		Authorities authoritie = currentSession.get(Authorities.class, id);
		return authoritie;
	}
	

	@Override
	public void deleteAuthoritie(String authority) {
		
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		
		// find the textbook
		Authorities authoritie = currentSession.get(Authorities.class, authority);
		
		currentSession.delete(authoritie);
		
		/*
		List<Authorities> auths = getAuthorities();
		
		List<User> users = userService.getUsers();
		
		for(int i=0; i<=auths.size(); i++) {
			if(auths.get(i).getUser().getUserName()==username) {
				String auth = auths.get(i).getAuthority();
				
				System.out.println(auth);
				Authorities authoritie = currentSession.get(Authorities.class, auth);
				currentSession.delete(authoritie);
			}
		}
		*/
		// delete textbook
		
	}
	
	@Override
	   public void updateAuthoritie(Authorities authority) {
	           // get current hibernate session
	           Session currentSession = sessionFactory.getCurrentSession();
	           // save the textbookprofile
			
			//System.out.println(textbookprofile);
	          
			System.out.println(authority);

			currentSession.update(authority);
	           
	   }
}
