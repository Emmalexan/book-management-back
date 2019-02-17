package gr.hua.dit.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gr.hua.dit.dao.CourseDAO;
import gr.hua.dit.entity.Course;
import gr.hua.dit.entity.TextBook;
@Service
public class CourseServiceImpl implements CourseService{
	
				@Autowired
				private CourseDAO courseDAO;
			
			
			@Override
			@Transactional
			public List<Course> getCourses(){
 
				// TODO Auto-generated method stub
				return courseDAO.getCourses();
			}


			@Override
			@Transactional
			public Course getCourse(int id) {
				
					// TODO Auto-generated method stub
					return courseDAO.getCourse(id);
				
			}
			
			@Override
			@Transactional
			public void addTextBook(TextBook textbook,int id) {
				
					// TODO Auto-generated method stub
					courseDAO.addTextBook(textbook,id);
				
			}
			@Override
			@Transactional
			public List<TextBook> viewCourseTextBooks(int cid){
				return courseDAO.viewCourseTextBooks(cid);
			}


			@Override
			@Transactional
			public void delete_textbook(int cid, int tid) {
				courseDAO.delete_textbook(cid, tid);				
			}

			@Override
			@Transactional
			public void updateCourse(Course course) {
				courseDAO.updateCourse(course);
				
			}
			
}
