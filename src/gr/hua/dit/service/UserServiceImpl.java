package gr.hua.dit.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gr.hua.dit.dao.UserDAO;
import gr.hua.dit.entity.Publisher;
import gr.hua.dit.entity.Secretary;
import gr.hua.dit.entity.Student;
import gr.hua.dit.entity.Teacher;
import gr.hua.dit.entity.TextBook;
import gr.hua.dit.entity.TextBookProfile;
import gr.hua.dit.entity.User;
import gr.hua.dit.dao.PublisherDAO;
import gr.hua.dit.dao.SecretaryDAO;
import gr.hua.dit.dao.StudentDAO;
import gr.hua.dit.dao.TeacherDAO;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private SecretaryDAO secretaryDAO;
	
	
	@Override
	@Transactional
	public List<User> getUsers() {
		return userDAO.getUsers();
	}

	@Override
	@Transactional
	public void saveUser(User user) {
		userDAO.saveUser(user);		
	}

	@Override
	@Transactional
	public User getUser(String username) {
		return userDAO.getUser(username);

	}

	@Override
	@Transactional
	public void deleteUser(String username) {
		userDAO.deleteUser(username);
		
	}

	@Override
	@Transactional
	public void updateUser(User user) {
		userDAO.updateUser(user);
		
	}
	
	//Secretary
	
	@Override
	@Transactional
	public List<Secretary> getSecretaries() {
		return secretaryDAO.getSecretaries();
	}

	@Override
	@Transactional
	public void saveSecretary(Secretary secretary) {
		secretaryDAO.saveSecretary(secretary);		
	}

	@Override
	@Transactional
	public Secretary getSecretary(int id) {
		return secretaryDAO.getSecretary(id);

	}

	@Override
	@Transactional
	public void deleteSecretary(int id) {
		secretaryDAO.deleteSecretary(id);
		
	}

	@Override
	@Transactional
	public void updateSecretary(Secretary secretary) {
		secretaryDAO.updateSecretary(secretary);
		
	}
	@Autowired
	private TeacherDAO teacherDAO;


@Override
@Transactional
public List<Teacher> getTeachers() {
	// TODO Auto-generated method stub
	return teacherDAO.getTeachers();
}

@Override
@Transactional
public Teacher getTeacher(int id) {
	// TODO Auto-generated method stub
	return teacherDAO.getTeacher(id);
}

@Override
@Transactional
public void saveTeacher(Teacher teacher) {
	
	teacherDAO.saveTeacher(teacher);
}

@Override
@Transactional
public void deleteTeacher(int id) {
	// TODO Auto-generated method stub
	teacherDAO.deleteTeacher(id);
}

@Override
@Transactional
public void updateTeacher(Teacher teacher) {
	teacherDAO.updateTeacher(teacher);
	
}
@Autowired
private StudentDAO studentDAO;


@Override
@Transactional
public List<Student> getStudents() {
// TODO Auto-generated method stub
return studentDAO.getStudents();
}


@Override
@Transactional
public Student getStudent(int id) {
// TODO Auto-generated method stub
return studentDAO.getStudent(id);
}

@Override
@Transactional
public void saveStudent(Student student) {

studentDAO.saveStudent(student);
}

@Override
@Transactional
public void deleteStudent(int id) {
// TODO Auto-generated method stub
studentDAO.deleteStudent(id);
}

@Override
@Transactional
public void updateStudent(Student student) {
studentDAO.updateStudent(student);

}

@Override
@Transactional
public List<TextBookProfile> viewStudentTextBooks(int sid){
return studentDAO.viewStudentTextBooks(sid);
}

@Override
@Transactional
public void delete_textbookprofile(int tid, int sid) {
studentDAO.delete_textbookprofile(tid, sid);				
}

@Override
@Transactional
public void addProfileBook(TextBookProfile textbookprofile, int sid) {

	// TODO Auto-generated method stub
	studentDAO.addProfileBook(textbookprofile,sid);

}
@Autowired
private PublisherDAO publisherDAO;


@Override
@Transactional
public List<Publisher> getPublishers() {
// TODO Auto-generated method stub
return publisherDAO.getPublishers();
}

@Override
@Transactional
public Publisher getPublisher(int id) {
// TODO Auto-generated method stub
return publisherDAO.getPublisher(id);
}

@Override
@Transactional
public void savePublisher(Publisher publisher) {

publisherDAO.savePublisher(publisher);
}

@Override
@Transactional
public void deletePublisher(int id) {
// TODO Auto-generated method stub
publisherDAO.deletePublisher(id);
}
@Override
@Transactional
public void updatePublisher(Publisher publisher) {
publisherDAO.updatePublisher(publisher);

}


}
