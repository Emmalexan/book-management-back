package gr.hua.dit.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Table;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import gr.hua.dit.entity.Course;
import gr.hua.dit.entity.Course_textbook;
import gr.hua.dit.entity.Publisher;
import gr.hua.dit.entity.TextBook;


@Repository
public class CourseDAOImpl implements CourseDAO {

	@Autowired
	private SessionFactory sessionFactory;
	

	@Override
	public List<Course> getCourses() {
		// get current hibernate session
				Session currentSession = sessionFactory.getCurrentSession();

				// create a query
				Query<Course> query = currentSession.createQuery("from Course", Course.class);

				// execute the query and get the results list
				List<Course> courses = query.getResultList();

				// return the results
				return courses;
	}

	@Override
	public Course getCourse(int id) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		//get and return Publisher
		Course course = currentSession.get(Course.class, id);

		// return the results
		return course;
	}
	
	

	
	
	@SuppressWarnings({ "null", "null", "null" })
	@Override
	@Transactional
	public List<Object> getCourse_textbooks_new(int cid) {
		Session currentSession = sessionFactory.getCurrentSession();
		System.out.println("eimai stin getCourse");
		//get and return Course
		//Course course = currentSession.get(Course.class, id);
		String SQL_QUERY ="Select textbook_id from Course_textbook where course_id=?0 ";
		//Session session = sessionFactory.openSession();
		Query query = currentSession.createQuery(SQL_QUERY);
		query.setParameter(0,cid);
		List<Course_textbook> textbooks=   query.getResultList();
		System.out.println(textbooks);
		
/*		List<TextBook> textbook = new ArrayList<TextBook>();
		for(int i=0;i<textbooks.size();i++) {
			System.out.println("print ta textbook_id");
			System.out.println(textbooks.get(i));
			SQL_QUERY ="SELECT text FROM TextBook text where id=?0";
			
			//Session session = sessionFactory.openSession();
	 		//currentSession = sessionFactory.getCurrentSession();
			Query<TextBook> query1 = currentSession.createQuery(SQL_QUERY);
			query1.setParameter(0,textbooks.get(i));
			System.out.println(query1.getResultList().get(0));
			textbook.add(query1.getResultList().get(0));
		//System.out.println(query.list());

		//query.setParameter(1,userPassword);
	}
		return textbook ;
	}
	*/
		
		List<Object> textbook = new ArrayList<Object>();
		for(int i=0;i<textbooks.size();i++) {
			System.out.println("print ta textbook_id");
			System.out.println(textbooks.get(i));
			SQL_QUERY ="SELECT id, title, writer, year, publishername, isbn, receivingPoint FROM TextBook where id=?0";
			Query<Object> query1 = currentSession.createQuery(SQL_QUERY);
			query1.setParameter(0,textbooks.get(i));
			System.out.println(query1.getResultList().get(0));
			textbook.add(query1.getResultList().get(0));
		}
		
		
		return textbook;
	}	
	
	
	
	
	@SuppressWarnings({ "null", "null", "null" })
	@Override
	@Transactional
	public List<Object> getAllCourses(int semester) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		System.out.println("eimai stin getAllCourse");
		//get and return Course
		//Course course = currentSession.get(Course.class, id);
		
		
		String SQL_QUERY ="Select id, title from Course where semester=?0 ";
		//Session session = sessionFactory.openSession();
		Query<Object> query = currentSession.createQuery(SQL_QUERY);
		
		query.setParameter(0,semester);
		List<Object> courses = query.getResultList();
		System.out.println(courses);
		

		return courses;
	}	
	
	
	
	
	@Override
	public void addTextBook(TextBook textbook, int id) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// ((Course) currentSession).addTextBook(textbook);
		Course course = currentSession.get(Course.class, id);
		course.addTextBook(textbook);
		
	           
	   }
	
	@Override
	public List<TextBook> viewCourseTextBooks(int cid) {
		// get current hibernate session
		System.out.println("1");
		Session currentSession = sessionFactory.getCurrentSession();
		System.out.println("2");
		// ((Course) currentSession).addTextBook(textbook);
		Course course = currentSession.get(Course.class, cid);
		System.out.println(cid);
		List<TextBook> c = course.getTextBooks();
		for(TextBook i: c) {
			System.out.println(i.getId());
		}
		return course.getTextBooks();
		
	           
	   }
	@Override
	public void delete_textbook(int cid,  int tid) {
		// get current hibernate session
		System.out.println("1_delete");
		Session currentSession = sessionFactory.getCurrentSession();
		System.out.println("2_delete");
		// ((Course) currentSession).addTextBook(textbook);
		Course course = currentSession.get(Course.class, cid);
		System.out.println(cid);
		List<TextBook> c = course.getTextBooks();
		
		for(int i=0; i<=c.size(); i++) {
			if(c.get(i).getId() == tid) {
		//for(TextBook i: c) {
		//	if(i.getId()== tid) {
				c.remove(i);
				
			}
		}
		return ;
		
	           
	   }
	
	@Override
	   public void updateCourse(Course course) {
	           // get current hibernate session
	           Session currentSession = sessionFactory.getCurrentSession();
	           // save the textbookprofile
			
			//System.out.println(textbookprofile);
	          
			System.out.println(course);

			currentSession.update(course);
	           
	   }
	


}
