package gr.hua.dit.service;

import java.util.List;

import gr.hua.dit.entity.Publisher;
import gr.hua.dit.entity.Secretary;
import gr.hua.dit.entity.Student;
import gr.hua.dit.entity.Teacher;
import gr.hua.dit.entity.TextBookProfile;
import gr.hua.dit.entity.User;

public interface UserService {
	public List<User> getUsers();

	public void saveUser(User user);
	
	public User getUser(String username);

	public void deleteUser(String username);

	public void updateUser(User user);

	public void saveSecretary(Secretary secretary);

	public List<Secretary> getSecretaries();

	public Secretary getSecretary(int id);

	public void deleteSecretary(int id);

	public void updateSecretary(Secretary secretary);
	
	public List<Teacher> getTeachers();

	public Teacher getTeacher(int id);

	public void saveTeacher(Teacher teacher);

	public void deleteTeacher(int id);

	public void updateTeacher(Teacher teacher);
	
	public List<Student> getStudents();
	
	public Student getStudent(int id);

	void saveStudent(Student student);

	void deleteStudent(int id);

	List<TextBookProfile> viewStudentTextBooks(int sid);

	void delete_textbookprofile(int tid, int sid);

	void addProfileBook(TextBookProfile textbookprofile, int sid);

	void updateStudent(Student student);
	
	public List<Publisher> getPublishers();

	public Publisher getPublisher(int id);

	public void savePublisher(Publisher publisher);

	public void deletePublisher(int id);

	public void updatePublisher(Publisher publisher);
}
