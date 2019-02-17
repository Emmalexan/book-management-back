package gr.hua.dit.dao;

import java.util.List;

import org.hibernate.query.Query;

import gr.hua.dit.entity.Course;
import gr.hua.dit.entity.Course_textbook;
import gr.hua.dit.entity.TextBook;

public interface CourseDAO {
	
	public List<Course> getCourses();
	
	public Course getCourse(int id);

	public void addTextBook(TextBook textbook, int id);

	public List<TextBook> viewCourseTextBooks(int cid);

	public void delete_textbook(int cid, int tid);

	public List<Object> getCourse_textbooks_new(int cid);

	List<Object> getAllCourses(int cid);

	void updateCourse(Course course);
}
