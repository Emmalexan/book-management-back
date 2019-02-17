package gr.hua.dit.api;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import gr.hua.dit.dao.CourseDAO;
import gr.hua.dit.dao.TextBookDAO;
import gr.hua.dit.entity.Course;
import gr.hua.dit.entity.Course_textbook;
import gr.hua.dit.entity.Student;
import gr.hua.dit.entity.TextBook;
import gr.hua.dit.entity.TextBookProfile;
import gr.hua.dit.entity.User;
import gr.hua.dit.entity.response;
import gr.hua.dit.service.CourseService;
import gr.hua.dit.service.UserService;
import gr.hua.dit.service.TextBookService;

@RestController
@RequestMapping("/api")
public class TextBookApiController {

	@Autowired
	private TextBookService textbookService;
	
	@Autowired
	private UserService studentService;

	@Autowired
	private CourseService courseService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CourseDAO courseDAO;
	
	@Autowired
	private TextBookDAO textbookDAO;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	boolean flag_name = false;
	boolean flag_pass = false;
	boolean flag_auth = false;
	

	
	
	
	 @GetMapping("/deleteStatement/{sid}")
	 public @ResponseBody response DeleteStatement(@PathVariable int sid) {
		 
		 response res = new response();
		// Student student = studentService.getStudent(sid);
		 List<TextBookProfile> profiles = textbookService.getTextBookProfiles();
		 for(int i =0; i<profiles.size(); i++) {
			 if(profiles.get(i).getStudent().getId() == sid) {
				 int profid = profiles.get(i).getId();
				 textbookService.deleteTextBookProfile(profid);
			 }
		 }
		 res.setMessage("ok");
		 return res;
	 }
	
	
	
	
	
	@GetMapping("/login/{username}/{password}")
	public @ResponseBody response Login(@PathVariable String username , @PathVariable String password) {
		List<User> users = userService.getUsers();
		User user = new User();
		response res = new response();

		for(int i=0; i<users.size(); i ++) {
			if(users.get(i).getUserName().equals(username)) {
				flag_name = true;
				if(users.get(i).getUserPassword().equals(password)) {
					flag_pass= true;
					if(users.get(i).getAuthoritie().getAuthority().equals("ROLE_STUDENT")) {
						flag_auth = true;
						user = userService.getUser(users.get(i).getUserName());
						res.setUser(user);
						res.setMessage("ok");
						return res;
					}
				}
			}
		}
		if(flag_name == true && flag_pass == false) {
			res.setMessage("wrong password");
			res.setUser(null);
		}else if(flag_name == false){
			res.setMessage("wrong username");
			res.setUser(null);
		}else if(flag_name == true && flag_pass == true && flag_auth == false) {
			res.setMessage("you are not a student");
			res.setUser(null);
		}
		return res;
	}
	
	
	
	
	 @GetMapping("/{id}")
	//@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = { "application/json", "application/xml" })
	public TextBook getTextBook(@PathVariable("id") int id) {
		 
		 

		TextBook textbook = textbookService.getTextBook(id);
		//String title = textbookService.getTextBook(id).getTitle();
		
		System.out.println("textbook :" + textbook);

		//return textbook;
		return textbook;
	}
	 
	 @GetMapping("/users")
     public List<User> listUsers() {
		 //List<TextBook> textbooks = courseService.getCourse(2).getTextBooks();
		// List<TextBook> textbooks = courseDAO.getCourse_textbooks_new(2);
             // get customers from dao
		//	System.out.println(textbooks);
		 List<User> users = userService.getUsers();	
			System.out.println(users);
             return users;
     }
	 
	 @GetMapping("/textbooks")
     public List<TextBook> listTextBooks() {
		 //List<TextBook> textbooks = courseService.getCourse(2).getTextBooks();
		// List<TextBook> textbooks = courseDAO.getCourse_textbooks_new(2);
             // get customers from dao
		//	System.out.println(textbooks);
		 List<TextBook> textbooks = textbookService.getTextBooks();	
			System.out.println(textbooks);
             return textbooks;
     }
	 @GetMapping("/theCourse/{cid}")
	 public Course TheCourse(@PathVariable("cid") int cid) {
		 Course course = courseService.getCourse(cid);
		 return course;
	 }
	 
	 @GetMapping("/courses/{sid}")
     public @ResponseBody  List<Course> listCourses(@PathVariable("sid") int sid) {
		 //List<TextBook> textbooks = courseService.getCourse(2).getTextBooks();
		// List<TextBook> textbooks = courseDAO.getCourse_textbooks_new(2);
             // get customers from dao
		//	System.out.println(textbooks);
		 Student student = studentService.getStudent(sid);
		 List<Course> courses = courseService.getCourses();
		 List<Course> s_courses = new ArrayList<Course>();
		 for(int i=0; i<courses.size(); i++) {
			 if(courses.get(i).getSemester()== student.getSemesterNum()) {
				 s_courses.add(courses.get(i));
			 }
		 }
		// List<Course> courses = courseService.getCourses();	
			System.out.println(s_courses);
             return s_courses;
     }
	 
	 @GetMapping("/profileTextbook/{sid}")
     public List<TextBookProfile> listProfile(@PathVariable("sid") int sid) {
		 //List<TextBook> textbooks = courseService.getCourse(2).getTextBooks();
		// List<TextBook> textbooks = courseDAO.getCourse_textbooks_new(2);
             // get customers from dao
		//	System.out.println(textbooks);
		 Student student = studentService.getStudent(sid);
		 List<TextBookProfile> profiles = textbookService.getTextBookProfiles();
		 List<TextBookProfile> s_bookprofile = new ArrayList<TextBookProfile>();
		
		 for(int i=0; i<profiles.size(); i++) {
			 if(profiles.get(i).getStudent().getId()==sid) {
				 s_bookprofile.add(profiles.get(i));
			 }
		 }
		 
		 System.out.println(s_bookprofile);
             return s_bookprofile;
     }
	 
	 
	 @GetMapping("/courseBooks/{cid}")
     public List<TextBook> listCourseTextBooks(@PathVariable("cid") int cid) { 
		 List<TextBook> textbooks = courseService.viewCourseTextBooks(cid);

		 return textbooks;
	 }
     
	 @GetMapping("/user/{username}")
     public User user(@PathVariable("username") String username) { 
		 
		 User user = userService.getUser(username);

		 return user;
	 }
	 
	

	@RequestMapping(value="/delete/{id}", method= RequestMethod.DELETE , produces = { "application/json", "application/xml" })
	public ResponseEntity deleteTextBook(@PathVariable("id") int id) {
		textbookService.deleteTextBook(id);
		return new ResponseEntity(HttpStatus.OK);
	}
	
	
	@PostMapping("/show")
	//@RequestMapping(value = "/add", method = RequestMethod.POST, produces = { "application/json", "application/xml" })
	public TextBook createTextBook(@RequestParam("title") String title,
			@RequestParam("writer") String writer, @RequestParam("year") String year, @RequestParam("publishername") String publishername, @RequestParam("isbn") String ISBN,@RequestParam("receivingPoint") String receivingPoint) {
		TextBook textbook = new TextBook(title,writer,year,publishername,ISBN,receivingPoint);
		textbookService.saveTextBook(textbook);
		return textbook;

	}

	@RequestMapping(value = "/jsonadd", method = RequestMethod.POST,  produces = { "application/json", "application/xml" })
	public TextBook createTextBookfromJson(@RequestBody TextBook textbook) {
		textbookService.saveTextBook(textbook);
		return textbook;
	}
	
	 @PostMapping("/addtextbook")
     public TextBook addTextbook(@RequestBody TextBook theTextbook) {
             
             // also just in case the pass an id in JSON ... set id to 0
             // this is force a save of new item ... instead of update
             // sample data (raw-application/json)
//             {
//                     "firstName": "Alekos",
//                     "lastName": "Sakellarios",
//                     "email": "alekos@hua.gr"
//             }
		 
             
		 theTextbook.setId(0);
             theTextbook.setTitle("Informatis");
             textbookService.saveTextBook(theTextbook);
             
             return theTextbook;
     }

	
	/* @GetMapping("/courses/{tid}")
     public List<Object> listCourses(@PathVariable("tid") int tid) {
		 
		 System.out.println("ok sto restcontroller");
		 List<Object> newcourses = new ArrayList<Object>();
		 
		 Student student = studentService.getStudent(tid);
		 int semester = student.getSemesterNum();		
		 
		List<Object> courses = courseDAO.getAllCourses(semester);
	
        return courses;
     }
	*/ 
	 @GetMapping("/textbooks/{tid}")
     public List<Object> listTextBooks(@PathVariable("tid") int tid) {
		 //List<TextBook> textbooks = courseService.getCourse(2).getTextBooks();
		 Student student = studentService.getStudent(tid);
		 
		 List<Object> newtextbooks = new ArrayList<Object>();
		 List<Course> courses = courseService.getCourses();
		 for(int i=0; i<courses.size(); i++) {
			 if(courses.get(i).getSemester() == student.getSemesterNum() ) {
				 int cid = courses.get(i).getId();
			 	List<Object> textbooks = courseDAO.getCourse_textbooks_new(cid);
             // get customers from dao
			 	System.out.println(textbooks);
			 	newtextbooks.add(textbooks);
		 	}
		 }
		 
			
             return newtextbooks;
     }
	 
	 @GetMapping("/textbooksProfile/{tid}")
     public List<Object> listTextBooksProfile(@PathVariable("tid") int tid) {
		 //List<TextBook> textbooks = courseService.getCourse(2).getTextBooks();
		 Student student = studentService.getStudent(tid);
		 
		 List<Object> newtextbooks = new ArrayList<Object>();
		 List<TextBookProfile> profiles = textbookService.getTextBookProfiles();
		 for(int i=0; i<profiles.size(); i++) {
			 if(profiles.get(i).getStudent().getId() == tid ) {
				 int profileid = profiles.get(i).getId();
			 	List<Object> bookprofiles = textbookDAO.ProfileTextbooks(profileid);
             // get customers from dao
			 	System.out.println(bookprofiles);
			 	newtextbooks.add(bookprofiles);
		 	}
		 }
		 
			
             return newtextbooks;
     }
	 
	 @GetMapping("/saveSelectedTextBook/{sid}/{tid}")
		public @ResponseBody response saveSelectedTextBook(@PathVariable("tid") int tid, @PathVariable("sid") int sid) {
			
			Boolean flag = false;
			System.out.println("STH SAVE");

			int cid = 0 ;
			response res = new response();
			TextBook textbook = textbookService.getTextBook(tid); 
			
			Student student = studentService.getStudent(sid);
	
		//	List<TextBook> textbooks = textbookService.getTextBooks();
			List<Course> courses = courseService.getCourses();
		
			for(int i =0; i<courses.size(); i++) {
				for(int j=0; j<courses.get(i).getTextBooks().size(); j++) {
					if(courses.get(i).getTextBooks().get(j).getId()== tid) {
						cid = courses.get(i).getId();
						break;
					}
					
				}
			}
			
			List<TextBook> course_books = courseService.viewCourseTextBooks(cid);
			List<TextBookProfile> book_profiles = textbookService.viewTextbookTextbookProfiles(sid);
				
			for (TextBookProfile bookprof : book_profiles){
				for(TextBook abook : course_books) {
					if(bookprof.getTextbook().getId() == abook.getId() ) {
						System.out.println("yparxei profile gia to book auto");
						
						Student stud = studentService.getStudent(sid);
						TextBook book = textbookService.getTextBook(tid);
						bookprof.setStudent(stud);
						bookprof.setTextbook(book);
						flag= true;
						
						System.out.println(".......sthn update");
						textbookService.updateTextBookProfile(bookprof);
						res.setMessage("update");
					}
				}	
			}
			if(flag== false) {
						TextBookProfile profile = new TextBookProfile();
						//int newbookProf = 1;
						//HttpSession currentSession2 = request.getSession();
						//currentSession2.setAttribute("newProf",newbookProf);
						
						TextBook newBook = textbookService.getTextBook(tid);
						System.out.println(".......sthn save");
						profile.setStudent(student);
						profile.setTextbook(newBook);
						profile.setConfirmationReceived(false);
						
						
						
						textbookService.saveTextBookProfile(profile);
						res.setMessage("save");
				}
					
			
			
			//textbookService.getTextBook(id)
			
			return res;
		}  
	 
	
}

