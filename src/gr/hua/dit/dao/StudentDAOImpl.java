package gr.hua.dit.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import gr.hua.dit.entity.Course;
import gr.hua.dit.entity.Student;
import gr.hua.dit.entity.Teacher;
import gr.hua.dit.entity.TextBook;
import gr.hua.dit.entity.TextBookProfile;

@Repository
public class StudentDAOImpl implements StudentDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Student> getStudents() {
		// get current hibernate session
				Session currentSession = sessionFactory.getCurrentSession();

				// create a query
				Query<Student> query = currentSession.createQuery("from Student", Student.class);

				// execute the query and get the results list
				List<Student> students = query.getResultList();

				// return the results
				return students;
	}

	@Override
	public Student getStudent(int id) {
		// get current hibernate session
				Session currentSession = sessionFactory.getCurrentSession();
				
				//get and return Student
				Student student = currentSession.get(Student.class, id);
				return student;
	}
	
	@Override
	   public void saveStudent(Student student) {
	           // get current hibernate session
	           Session currentSession = sessionFactory.getCurrentSession();
	           // save the textbook
		
			currentSession.save(student);
	           
	   }
	
	@Override
	public void deleteStudent(int id) {
		
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// find the textbook
		Student student = currentSession.get(Student.class, id);
		
		// delete textbook
		currentSession.delete(student);
	}
	
	@Override
	   public void updateStudent(Student student) {
	           // get current hibernate session
	           Session currentSession = sessionFactory.getCurrentSession();
	           
			System.out.println(student);

			currentSession.update(student);
	           
	   }
	
	@Override
	public List<TextBookProfile> viewStudentTextBooks(int sid) {
		// get current hibernate session
		System.out.println("1");
		Session currentSession = sessionFactory.getCurrentSession();
		System.out.println("2");
		// ((Course) currentSession).addTextBook(textbook);
		Student student = currentSession.get(Student.class, sid);
		System.out.println(sid);
		List<TextBookProfile> st = student.getTextbookprofiles();
		for(TextBookProfile i: st) {
			System.out.println(i.getId());
		}
		return student.getTextbookprofiles();
		
	           
	   }
	
	@Override
	public void delete_textbookprofile(int tid, int sid) {
		// get current hibernate session
		System.out.println("1_delete");
		Session currentSession = sessionFactory.getCurrentSession();
		System.out.println("2_delete");
		// ((Course) currentSession).addTextBook(textbook);
		Student student = currentSession.get(Student.class, sid);
		System.out.println(student);
		List<TextBookProfile> profileBooks = student.getTextbookprofiles();
		for(TextBookProfile prof: profileBooks)
		{
			if(prof.getTextbook().getId() == tid) {
		//for(TextBook i: c) {
		//	if(i.getId()== tid) {
				//profileBooks.remove(i);
				int profid = prof.getId();
				System.out.println(profid);
				
				TextBookProfile textbookprofile = currentSession.get(TextBookProfile.class, profid);
				
				// delete textbook
				currentSession.delete(textbookprofile);
				
			}
		}
		return ;
	}
	
	@Override
	public void addProfileBook(TextBookProfile textbookprofile, int sid) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// ((Course) currentSession).addTextBook(textbook);
		Student student = currentSession.get(Student.class, sid);
		student.addProfileBook(textbookprofile);
		
	           
	   }
}
