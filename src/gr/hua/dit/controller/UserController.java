package gr.hua.dit.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import gr.hua.dit.entity.Authorities;
import gr.hua.dit.entity.Course;
import gr.hua.dit.entity.Publisher;
import gr.hua.dit.entity.Secretary;
import gr.hua.dit.entity.Student;
import gr.hua.dit.entity.Teacher;
import gr.hua.dit.entity.TextBook;
import gr.hua.dit.entity.User;
import gr.hua.dit.service.AuthoritiesService;
import gr.hua.dit.service.CourseService;
import gr.hua.dit.service.UserService;
import gr.hua.dit.service.UserService;
import gr.hua.dit.service.UserService;
import gr.hua.dit.service.TextBookService;
import gr.hua.dit.service.UserService;


@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private UserService teacherService;
	
	
	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	private AuthoritiesService authoritieService;
	
	@Autowired
	private UserService secretaryService;
	
	@Autowired
	private UserService publisherService;
	
	@Autowired
	private CourseService courseService;
	
	@Autowired
	private TextBookService textbookService;
	
	@Autowired
	private UserService studentService;
	
	@Resource(name="sessionFactory")
    protected SessionFactory sessionFactory;

	@GetMapping("/listuser")
	public String listUser(Model model) {
		
		// get users from the service
		List<User> users = userService.getUsers();
		List<Authorities> authorities  = authoritieService.getAuthorities();
		
		// add the users to the model
		model.addAttribute("users",users);
		model.addAttribute("authorities",authorities);
		
		// add page title
		model.addAttribute("pageTitle", "List of Users");
		return "list-users";
	}
	

	
	


	@GetMapping("/showAddForm")
	public String showAddForm(Model model) {
		// create model attribute to get form data
		
		User user = new User();
	
		int newUser = 1 ;
		System.out.println(newUser);
		String username = "ok";
		
		model.addAttribute("newUser",newUser);
		model.addAttribute("user",user);
		
		model.addAttribute("username",username);

		// add page title
		model.addAttribute("pageTitle", "Add User");
		return "user-form";
	}
	
	
	@GetMapping("/{username}")
	public String getUser(Model model, @PathVariable("username") String username) {
		// get the user
		
		User user = userService.getUser(username);
		
		int newUser = 0;
		
		System.out.println(newUser);
		
		model.addAttribute("newUser", newUser);
		model.addAttribute("user", user);

		return "user-form";
	}
	
	
	@PostMapping("/saveUser/{newUser}/{username}")
	public String saveUser(@ModelAttribute("user") User user, @PathVariable("newUser") int newUser, @PathVariable("username") String username) {
		
		System.out.println(newUser);

		
		if(newUser == 1) {
			System.out.println("kainoyrgiow xrhsths");
			System.out.println(username);
//			Authorities tempauth = new Authorities();
			
			//user.getAuthoritie().setAuthority(null);;
			
			System.out.println(username);
			userService.saveUser(user);
			String usernm = user.getUserName();
			System.out.println(usernm);
			
			HttpSession currentSession = request.getSession();
		
			currentSession.setAttribute("usernm",usernm);
			
			String t =(String) currentSession.getAttribute("usernm");
			return "redirect:/authorities/showRoleForm/"+t ;
/*			tempauth.setUser(user);
			tempauth.setAuthority(" ");
			
			authoritieService.saveAuthoritie(tempauth);    */
		}
		if(newUser == 0) {
			System.out.println("update xrhsth");
			User tempuser = userService.getUser(username);
			Authorities author = tempuser.getAuthoritie();
			user.setAuthoritie(author);
			userService.updateUser(user);
			return "redirect:/user/listuser";
		}
		
	
		//return "redirect:/user/listuser";
		return "redirect:/user/listuser";
	}
	
	
	
	
	
	
	
/*	
	
	@PostMapping("/saveUser/{authority}")
	public String saveUserAuthor(@ModelAttribute("user") User user, @PathVariable("authority") String authority, Model model){
		
		
		System.out.println("bhke sth save user");
		
		
		User tempUser = userService.getUser(user.getUserName());
		System.out.println(tempUser.getUserName());
		
		
		//Role tempRole = new Role();
		
		Authorities tempAuthor = new Authorities();
//		tempAuthor = authoritieService.getAuthoritie(authority);
		
//		tempAuthor.setAuthority(authority);
		tempAuthor.setUser(user);
		
//		userService.saveUser(user);
		
		
		
		
		
		
		
		//user.setRole(tempRole);
		//user.setAuthorities(authorities);
		
	//	System.out.println(user.getRole().getNameRole());
		
		userService.saveUser(user);
		//int idUser = user.getId();
		
		
		if(user.getRole().getNameRole().equals("teacher") || user.getRole().getNameRole().equals("Teacher") || user.getRole().getNameRole().equals("TEACHER")) {	
			Teacher teacher = new Teacher();
			teacher.setUser(user);
			int idUser = user.getId();
			System.out.println(idUser);
			
			model.addAttribute("teacher", teacher);
			model.addAttribute("idUser", idUser);
			return "teacher-form";		
		}
		else if  (user.getRole().getNameRole().equals("publisher") || user.getRole().getNameRole().equals("Publisher") || user.getRole().getNameRole().equals("PUBLISHER")) {
			Publisher publisher = new Publisher();
			publisher.setUser(user);
			int idUser = user.getId();
			System.out.println(idUser);
			model.addAttribute("idUser", idUser);
			model.addAttribute("publisher", publisher);
			return "publisher-form";		
		}
		else if(user.getRole().getNameRole().equals("admin") || user.getRole().getNameRole().equals("Admin") || user.getRole().getNameRole().equals("ADMIN")) {	
			model.addAttribute("user", user);
			return "admin-form";		
		} 
		else if(user.getRole().getNameRole().equals("student") || user.getRole().getNameRole().equals("Student") || user.getRole().getNameRole().equals("STUDENT")) {
			Student student = new Student();
			student.setUser(user);
			int idUser = user.getId();
			System.out.println(idUser);
			model.addAttribute("idUser", idUser);
			model.addAttribute("student", student);
			return "student-form";		
		}
		else if(user.getRole().getNameRole().equals("secretary") || user.getRole().getNameRole().equals("Secretary") || user.getRole().getNameRole().equals("SECRETARY")) {	
		//	Secretary secretary = new Secretary();
		//	secretary.setUser(user);
		//	int idUser = user.getId();
		//	System.out.println(idUser);
		//	model.addAttribute("idUser", idUser);
		//	model.addAttribute("secretary", secretary);
			return "secretary-form";		
		}
		
		
		return "redirect:/user/listuser";
		
	} */
	
/*	
	@PostMapping("/saveUser/saveDetailsTeacher/{idUser}")
	public String saveDetailsTeacher(@ModelAttribute("teacher") Teacher teacher,@PathVariable("idUser") int idUser){
		
		User user = userService.getUser(idUser);
		teacher.setUser(user);
		
		teacherService.saveTeacher(teacher);
		System.out.println(teacher.getId());
		System.out.println("bhke sth save Details Teacher");
		return "redirect:/user/listuser";
	
	}
	
	@PostMapping("/saveUser/saveDetailsPublisher/{idUser}")
	public String saveDetailsPublisher(@ModelAttribute("publisher") Publisher publisher, @PathVariable("idUser") int idUser){
		
		User user = userService.getUser(idUser);
		publisher.setUser(user);
		
		publisherService.savePublisher(publisher);
		System.out.println("bhke sth save Details Publisher");
		return "redirect:/user/listuser";
	} */
	
	@PostMapping("/saveDetailsStudent/{username}/{sid}")
	public String saveDetailsStudent(@ModelAttribute("student") Student student,@PathVariable("username") String username, @PathVariable("sid") int sid){
	
		//Student stud = studentService.getStudent(idStud);
		User user = userService.getUser(username);
		//student.setUser(user);
		
		if(sid == 0) {
			System.out.println(sid + "sth save");
			System.out.println(student.getId());
			
			student.setUser(user);
			studentService.saveStudent(student);
		}else if(sid != 0) {
			
			System.out.println(sid + "sth update");
		
			//student.setId(sid);
			student.setUser(user);
			String nmmm = student.getUser().getUserName();
			System.out.println(nmmm);

			studentService.updateStudent(student);
		}
		//studentService.saveStudent(student);
		System.out.println("bhke sth save Details Student");
		return "redirect:/user/listuser";
	}
	
	@PostMapping("/saveDetailsSecretary/{username}/{secid}")
	public String saveDetailsSecretary(@ModelAttribute("secretary") Secretary secretary ,@PathVariable("username") String username, @PathVariable("secid") int secid){
	
		//Student stud = studentService.getStudent(idStud);
		User user = userService.getUser(username);
		//student.setUser(user);
		
		if(secid == 0) {
			System.out.println(secid + "sth save");
			System.out.println(secretary.getId());
			
			secretary.setUser(user);
			secretaryService.saveSecretary(secretary);
			
		}else if(secid != 0) {
			
			System.out.println(secid + "sth update");
			
			secretary.setId(secid);
			secretary.setUser(user);
			String nmmm = secretary.getUser().getUserName();
			System.out.println(nmmm);

			secretaryService.updateSecretary(secretary);
		}
		//studentService.saveStudent(student);
		System.out.println("bhke sth save Details Secretary");
		return "redirect:/user/listuser";
	}	
	
	
	@PostMapping("/saveDetailsPublisher/{username}/{pid}")
	public String saveDetailsPublisher(@ModelAttribute("publisher") Publisher publisher,@PathVariable("username") String username, @PathVariable("pid") int pid){
	
		//Student stud = studentService.getStudent(idStud);
		User user = userService.getUser(username);
		//student.setUser(user);
		
		if(pid == 0) {
			System.out.println(pid + "sth save");
			System.out.println(publisher.getId());
			
			publisher.setUser(user);
			publisherService.savePublisher(publisher);
		}else if(pid != 0) {
			
			System.out.println(pid + "sth update");
			
			publisher.setId(pid);
			publisher.setUser(user);
			String nmmm = publisher.getUser().getUserName();
			System.out.println(nmmm);

			publisherService.updatePublisher(publisher);
		}
		//studentService.saveStudent(student);
		System.out.println("bhke sth save Details Publisher");
		return "redirect:/user/listuser";
	}
	
	@PostMapping("/saveDetailsTeacher/{username}/{tid}")
	public String saveDetailsTeacher(@ModelAttribute("teacher") Teacher teacher, @PathVariable("username") String username, @PathVariable("tid") int tid){
	
		//Student stud = studentService.getStudent(idStud);
		User user = userService.getUser(username);
		//student.setUser(user);
		
		if(tid == 0) {
			System.out.println(tid + "sth save");
			System.out.println(teacher.getId());
			
			teacher.setUser(user);
			teacherService.saveTeacher(teacher);
		}else if(tid != 0) {
			
			System.out.println(tid + "sth update");
			
			teacher.setId(tid);
			teacher.setUser(user);
			String nmmm = teacher.getUser().getUserName();
			System.out.println(nmmm);

			teacherService.updateTeacher(teacher);
		}
		//studentService.saveStudent(student);
		System.out.println("bhke sth save Details Teacher");
		return "redirect:/user/listuser";
	}
	
	
	
	@GetMapping("/Details/{username}")
	public String viewDetails(Model model, @PathVariable("username") String username) {
	
		User user = userService.getUser(username);
		System.out.println(user.getUserName());
		
		if(user.getAuthoritie().getAuthority().equals("ROLE_TEACHER")) {
			
			int tid = userService.getUser(username).getTeacher().getId();
			System.out.println(tid);
			Teacher teacher = teacherService.getTeacher(tid);
			model.addAttribute("tid", tid);
			model.addAttribute("teacher", teacher);
			model.addAttribute("username", username);
			return "teacher-form";
		}
		else if  (user.getAuthoritie().getAuthority().equals("ROLE_PUBLISHER")) {
			
			int pid = userService.getUser(username).getPublisher().getId();
			System.out.println(pid);
			Publisher publisher = publisherService.getPublisher(pid);
			model.addAttribute("pid", pid);
			model.addAttribute("publisher", publisher);
			model.addAttribute("username", username);
			return "publisher-form";
		}
		else if(user.getAuthoritie().getAuthority().equals("ROLE_ADMIN")) {	
			//model.addAttribute("username", username);
			return "redirect:/user/listuser";		
		} 
		else if(user.getAuthoritie().getAuthority().equals("ROLE_STUDENT")) {
			
			int sid = userService.getUser(username).getStudent().getId();
			System.out.println(sid);
			Student student = studentService.getStudent(sid);
			model.addAttribute("sid", sid);
			model.addAttribute("student", student);
			model.addAttribute("username", username);
			return "student-form";
		}
		else if(user.getAuthoritie().getAuthority().equals("ROLE_SECRETARY")) {	
			
			int secid = userService.getUser(username).getSecretary().getId();
			System.out.println(secid);
			Secretary secretary = secretaryService.getSecretary(secid);
			model.addAttribute("secid", secid);
			model.addAttribute("secretary", secretary);
			model.addAttribute("username", username);	
			return "secretary-form";
			
		}
			System.out.println("There is no role with this name");
			return "redirect:/user/listuser";
		
	}
	
	
	
	@GetMapping("/ShowDetailsForm/{username}")
	public String DetailsForm(Model model, @PathVariable("username") String username) {
		User user = userService.getUser(username);
		System.out.println(user.getUserName());
		
		if(user.getAuthoritie().getAuthority().equals("ROLE_TEACHER")) {
			
			Teacher teacher = new Teacher();
			int tid = teacher.getId();
			System.out.println(tid);
			//int newSt = 1;
			
			model.addAttribute("tid", tid);
			model.addAttribute("teacher", teacher);
			model.addAttribute("username", username);
			return "teacher-form";		
			
		}
		else if  (user.getAuthoritie().getAuthority().equals("ROLE_PUBLISHER")) {
			
			Publisher publisher = new Publisher();
			int pid = publisher.getId();
			System.out.println(pid);
			//int newSt = 1;
			
			model.addAttribute("pid", pid);
			model.addAttribute("publisher", publisher);
			model.addAttribute("username", username);
			return "publisher-form";		
		}
		else if(user.getAuthoritie().getAuthority().equals("ROLE_ADMIN")) {	
			//model.addAttribute("username", username);
			return "redirect:/user/listuser";		
		} 
		else if(user.getAuthoritie().getAuthority().equals("ROLE_STUDENT")) {
			//Student student = new Student();
			
	//		int idStud = userService.getUser(username).getStudent().getId();
	//		System.out.println(idStud);
			Student student = new Student();
			int sid = student.getId();
			System.out.println(sid);
			//int newSt = 1;
			
			model.addAttribute("sid", sid);
			model.addAttribute("student", student);
			model.addAttribute("username", username);
			return "student-form";		
		}
		else if(user.getAuthoritie().getAuthority().equals("ROLE_SECRETARY")) {	
			
			Secretary secretary = new Secretary();
			int secid = secretary.getId();
			System.out.println(secid);
			//int newSt = 1;
			
			model.addAttribute("secid", secid);
			model.addAttribute("secretary", secretary);
			model.addAttribute("username", username);		
			return "secretary-form";		
		}else if(user.getAuthoritie().getAuthority().equals("null")) {	
			return "redirect:/user/listuser";
		}
			System.out.println("There is no role with this name");
			return "redirect:/user/listuser";
		
	}  
	
	@GetMapping("/delete/{username}")
	public String deleteUser(@PathVariable("username") String username, Model model) {
	
		User user = userService.getUser(username);
		
		if(user.getAuthoritie().getAuthority().equals("ROLE_TEACHER")) {
			List<Course> courses = courseService.getCourses();
			int tid = user.getTeacher().getId();
			for(int i=0; i<courses.size(); i++) {
				if(courses.get(i).getTeacher().getId() == tid) {
					courses.get(i).setTeacher(null);
					courseService.updateCourse(courses.get(i));
					System.out.println("ginetai update sto course"+ i);
				}
			}
		}
		if(user.getAuthoritie().getAuthority().equals("ROLE_PUBLISHER")) {
			List<TextBook> textbooks = textbookService.getTextBooks();
			int pid = user.getPublisher().getId();
			for(int i=0; i<textbooks.size(); i++) {
				if(textbooks.get(i).getPublisher().getId() == pid) {
					textbooks.get(i).setPublisher(null);
					textbookService.updateTextBook(textbooks.get(i));;
					System.out.println("ginetai update sto textbook"+ i);
				}
			}
		}
	
		userService.deleteUser(username);

		System.out.println("bhke sth delete user");
		return "redirect:/user/listuser"; 
	}

	

	
	@GetMapping("/function")
	public String getFunction(Model model) {
		
		Authorities role = new Authorities();
		model.addAttribute("role", role);
		
		// add page title
		model.addAttribute("pageTitle", "Choose role");
		
		return "add-function";
	}
	
	
	
	/*
	@GetMapping("/rolelist")
	public String getRole() {
		return "rolelist.json";
	} */
	
	
}
