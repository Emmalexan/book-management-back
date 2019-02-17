package gr.hua.dit.dao;

import java.util.List;

import gr.hua.dit.entity.Student;
import gr.hua.dit.entity.TextBookProfile;

public interface StudentDAO {
	public List<Student> getStudents();
	
	public Student getStudent(int id);

	public void saveStudent(Student student);

	public void deleteStudent(int id);

	List<TextBookProfile> viewStudentTextBooks(int sid);

	void delete_textbookprofile(int tid, int sid);

	void addProfileBook(TextBookProfile textbookprofile, int sid);

	void updateStudent(Student student);
}
