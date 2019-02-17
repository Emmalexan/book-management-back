package gr.hua.dit.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import gr.hua.dit.entity.Publisher;
import gr.hua.dit.entity.Teacher;
import gr.hua.dit.entity.TextBook;

@Repository
public class TeacherDAOImpl implements TeacherDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	
	@Override
	
	public List<Teacher> getTeachers() {
		// get current hibernate session
				Session currentSession = sessionFactory.getCurrentSession();

				// create a query
				Query<Teacher> query = currentSession.createQuery("from Teacher", Teacher.class);

				// execute the query and get the results list
				List<Teacher> teachers = query.getResultList();

				// return the results
				return teachers;
	}
	
	@Override
	public Teacher getTeacher(int id) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//get and return Teacher
		Teacher teacher = currentSession.get(Teacher.class, id);
		return teacher;
	}
	
	@Override
	   public void saveTeacher(Teacher teacher) {
	           // get current hibernate session
	           Session currentSession = sessionFactory.getCurrentSession();
	           // save the textbook
		
			currentSession.save(teacher);
	           
	   }
	
	@Override
	public void deleteTeacher(int id) {
		
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// find the textbook
		Teacher teacher = currentSession.get(Teacher.class, id);
		
		// delete textbook
		currentSession.delete(teacher);
	}
	
	@Override
	   public void updateTeacher(Teacher teacher) {
	           // get current hibernate session
	           Session currentSession = sessionFactory.getCurrentSession();
	           
			System.out.println(teacher);

			currentSession.update(teacher);
	           
	   }
}
