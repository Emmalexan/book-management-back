package gr.hua.dit.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import gr.hua.dit.entity.Authorities;
import gr.hua.dit.entity.Function;


@Repository
public class FunctionDAOImpl implements FunctionDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public List<Function> getFunctions() {
		Session currentSession = sessionFactory.getCurrentSession();
		// create a query
		Query<Function> query = currentSession.createQuery("from Function", Function.class);
		// execute the query and get the results list
		List<Function> functions = query.getResultList();
		// return the results
		return functions;
	}

	@Override
	public void deleteFunction(int id) {
		// get current hibernate session
				Session currentSession = sessionFactory.getCurrentSession();
				// find the user
				Function function = currentSession.get(Function.class, id);
				// delete user
				currentSession.delete(function);
	}
	
	@Override
	   public void saveFunction(Function function) {
	           // get current hibernate session
	           Session currentSession = sessionFactory.getCurrentSession();
	           // save the textbook
		
			currentSession.save(function);
	           
	   }
	
	
	@Override
	public Function getFunction(int id) {
Session currentSession = sessionFactory.getCurrentSession();
		
		//get and return Teacher
Function function = currentSession.get(Function.class, id);
		return function;
	}

	@Override
	public void updateFunction(Function function) {
		 Session currentSession = sessionFactory.getCurrentSession();
        
		System.out.println(function);

		currentSession.update(function);
		
	}
	
/*	@Override
	public void updateFunctions(int id, Role role) {

		 Session currentSession = sessionFactory.getCurrentSession();
			
			//get and return Teacher
		 
		 List<Function> functions = getFunctions() ;
		 for(Function i: functions) {
			 System.out.println(i.getRole().getId());
			 System.out.println(role.getId());
		 if (i.getRole().getId() == role.getId())
				 
				// functions.get(i).getRole().getNameRole()== rolename);
			// delete user
			currentSession.update(i);
	}
	}*/
	@Override
	public void updateFunctions(int id, Authorities auth) {

		 Session currentSession = sessionFactory.getCurrentSession();
			
			//get and return Teacher
		 
		 List<Function> functions = getFunctions() ;
		 for(Function i: functions) {
			 System.out.println(i.getAuthority());
		//	 System.out.println(role.getId());
		 if (i.getAuthority() == auth)
				 
				// functions.get(i).getRole().getNameRole()== rolename);
			// delete user
			currentSession.update(i);
	}
	}
}
