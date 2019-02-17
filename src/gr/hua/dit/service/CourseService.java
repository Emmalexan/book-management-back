package gr.hua.dit.service;

import java.util.List;

import gr.hua.dit.entity.Course;
import gr.hua.dit.entity.TextBook;

public interface CourseService {
	public List<Course> getCourses();
	public Course getCourse(int id);
	void addTextBook(TextBook textbook,int id);
	public List<TextBook> viewCourseTextBooks(int cid);

	void delete_textbook(int cid, int tid);
	void updateCourse(Course course);


}
