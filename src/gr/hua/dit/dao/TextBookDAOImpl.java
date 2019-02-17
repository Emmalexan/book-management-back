package gr.hua.dit.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import gr.hua.dit.entity.Course;
import gr.hua.dit.entity.Publisher;
import gr.hua.dit.entity.Student;
import gr.hua.dit.entity.TextBook;
import gr.hua.dit.entity.TextBookProfile;

@Repository
public class TextBookDAOImpl implements TextBookDAO {

	@Autowired
	private SessionFactory sessionFactory;

/*	@Override
	public List<TextBook> getTextBooks() {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// create a query
		//Query<TextBook> query = currentSession.createQuery("from TextBook", TextBook.class);
		String SQL_QUERY =" from Textbook ";
		//Session session = sessionFactory.openSession();
		Query query = currentSession.createQuery(SQL_QUERY);
		//query.setParameter(1,userPassword);
		System.out.println("eimai stin gettextbook skata");
		System.out.println(query.list());
		// execute the query and get the results list
		List<TextBook> textbooks = query.getResultList();

		// return the results
		return textbooks;
	}*/
	
	
	@Override
	public List<TextBook> getTextBooks() {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// create a query
		Query<TextBook> query = currentSession.createQuery("from TextBook", TextBook.class);

		// execute the query and get the results list
		List<TextBook> textbooks = query.getResultList();

		// return the results
		return textbooks;
	}
	
	@Override
	   public void saveTextBook(TextBook textbook) {
	           // get current hibernate session
	           Session currentSession = sessionFactory.getCurrentSession();
	           // save the textbook
			if(textbook.getIsbn().equals("")) {
				textbook.setIsbn(null);
			}
			if(textbook.getYear().equals("")) {
				textbook.setYear(null);
			}
			System.out.println(textbook);

			currentSession.save(textbook);
	           
	   }
	
/*	@Override
	public TextBook getTextBook(int id) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//get and return Textbook
		String SQL_QUERY =" from Textbook where id=?0 ";
		//Session session = sessionFactory.openSession();
		Query query = currentSession.createQuery(SQL_QUERY);
		query.setParameter(0,id);
		//query.setParameter(1,userPassword);
		System.out.println("eimai stin gettextbook skata");
		System.out.println(query.list());
		//TextBook textbook = currentSession.get(TextBook.class, id);
		return (TextBook)query.list().get(0);
	}*/
	
	@Override
	public TextBook getTextBook(int id) {
Session currentSession = sessionFactory.getCurrentSession();
		
		//get and return Publisher
	TextBook textbook = currentSession.get(TextBook.class, id);
		return textbook;
	}
	

	@Override
	public void deleteTextBook(int id) {
		
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// find the textbook
		TextBook textbook = currentSession.get(TextBook.class, id);
		
		// delete textbook
		currentSession.delete(textbook);
	}
	
	
	@Override
	public List<TextBookProfile> getTextBookProfiles() {
		// get current hibernate session
				Session currentSession = sessionFactory.getCurrentSession();

				// create a query
				Query<TextBookProfile> query = currentSession.createQuery("from TextBookProfile", TextBookProfile.class);

				// execute the query and get the results list
				List<TextBookProfile> textbookprofiles = query.getResultList();

				// return the results
				return textbookprofiles;
	}
	
	@Override
	public TextBookProfile getTextBookProfile(int id) {
		// get current hibernate session
				Session currentSession = sessionFactory.getCurrentSession();
				
				//get and return textbookprofile
				TextBookProfile textbookprofile = currentSession.get(TextBookProfile.class, id);
				return textbookprofile;
	}
	
	@Override
	   public void saveTextBookProfile(TextBookProfile textbookprofile) {
	           // get current hibernate session
	           Session currentSession = sessionFactory.getCurrentSession();
	           // save the textbookprofile
			
			System.out.println(textbookprofile);

			currentSession.save(textbookprofile);
	           
	   }
	

	@Override
	   public void updateTextBook(TextBook textbook) {
	           // get current hibernate session
	           Session currentSession = sessionFactory.getCurrentSession();
	           // save the textbookprofile
			
			//System.out.println(textbookprofile);
	          
			System.out.println(textbook);

			currentSession.update(textbook);
	           
	   }
	
	@Override
	   public void updateTextBookProfile(TextBookProfile textbookprofile) {
	           // get current hibernate session
	           Session currentSession = sessionFactory.getCurrentSession();
	          
			//System.out.println(textbookprofile);
	          
			System.out.println(textbookprofile);

			currentSession.update(textbookprofile);
	           
	   }


	@Override
	public void deleteTextBookProfile(int id) {
		
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
	
		// find the textbook
		TextBookProfile textbookprofile = currentSession.get(TextBookProfile.class, id);
		
		// delete textbook
		currentSession.delete(textbookprofile);
	}

	@Override
	public List<TextBookProfile> viewTextbookTextbookProfiles(int sid) {
		// get current hibernate session
		System.out.println("1");
		Session currentSession = sessionFactory.getCurrentSession();
		System.out.println("2");
		// ((Course) currentSession).addTextBook(textbook);
		Student student = currentSession.get(Student.class, sid);
		System.out.println(sid);
		List<TextBookProfile> t = student.getTextbookprofiles();
		for(TextBookProfile i: t) {
			System.out.println(i.getId());
		}
		return student.getTextbookprofiles();
		
	           
	   }
	
	@SuppressWarnings({ "null", "null", "null" })
	@Override
	@Transactional
	public List<Object> ProfileTextbooks(int profileid) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		System.out.println("eimai stin ProfileTextbooks");
		//get and return Course
		//Course course = currentSession.get(Course.class, id);
		
		
		String SQL_QUERY ="SELECT id, confirmationReceived FROM TextBookProfile WHERE id=?0 ";
		//Session session = sessionFactory.openSession();
		Query<Object> query = currentSession.createQuery(SQL_QUERY);
		
		query.setParameter(0,profileid);
		List<Object> profiles = query.getResultList();
		System.out.println(profiles);
		

		return profiles;
	}	

}
