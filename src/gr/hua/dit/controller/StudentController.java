package gr.hua.dit.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import gr.hua.dit.entity.Course;
import gr.hua.dit.entity.Student;
import gr.hua.dit.entity.TextBook;
import gr.hua.dit.entity.TextBookProfile;
import gr.hua.dit.service.CourseService;
import gr.hua.dit.service.UserService;
import gr.hua.dit.service.TextBookService;



@Controller
@RequestMapping("/student")
public class StudentController {
	@Autowired
	private HttpServletRequest request;
	@Autowired
	private UserService studentService;
	@Autowired
	private CourseService courseService;
	@Autowired
	private TextBookService textbookService;
	
	@GetMapping("/{sid}")
	public String listStudentCourses(Model model , @PathVariable("sid") int sid) {
					System.out.println("hi");
					HttpSession currentSession = request.getSession();
					currentSession.setAttribute("student_id",sid);

					Student student = studentService.getStudent(sid);
					
					List<Course> courses = courseService.getCourses();
					
					// add the teacher and courses to the model
					model.addAttribute("student",student);
					model.addAttribute("courses",courses);
					
					// add page title
					model.addAttribute("pageTitle", "Students' Courses");
					return "student-courses";
	}	
	
	@GetMapping("/{sid}/selectcourse_textbooks/{cid}")
	public String listSelectingTextBook(Model model , @PathVariable("cid") int cid, @PathVariable("sid") int sid) {
		Boolean flag = false;
	
		Course course = courseService.getCourse(cid);
	
		List<TextBook> course_books = courseService.viewCourseTextBooks(cid);
//		List<TextBookProfile> student_bookProfile = studentService.viewStudentTextBooks(sid);
		
//		List<TextBook> non_ex = new ArrayList<TextBook>();
		
		model.addAttribute("course",course);
		
		/*	for (TextBook courseTextbook: course_books){
			flag = false;
			for(TextBookProfile ex_studentProfile: student_bookProfile) {
				if(courseTextbook.getId()==ex_studentProfile.getTextbook().getId()) {
					//System.out.println("ok");
					flag=true;
				}
			}
			if(flag==false) {
				non_ex.add(courseTextbook);
			}
		}*/
		
		Student student = studentService.getStudent(sid);
//		model.addAttribute("student_bookProfile",student_bookProfile);
		model.addAttribute("course",course);
		model.addAttribute("student",student);
//		model.addAttribute("non_ex",non_ex);
		
		model.addAttribute("course_books",course_books);
		HttpSession currentSession = request.getSession();
		currentSession.setAttribute("course_id",cid);
	
					// add page title
					model.addAttribute("pageTitle", "List of Textbooks");
					return "student-select-textbook";
	}
	
	@PostMapping("/{sid}/DeleteSelectedTextBook/{tid}")
	public String DeleteSelectedTextBook(@ModelAttribute("textbooks") TextBook textbooks, @PathVariable("tid") int tid, @PathVariable("sid") int sid) {
		System.out.println("STH DELETE");
		HttpSession currentSession = request.getSession();
		int t = (int) currentSession.getAttribute("student_id");
		
	//	TextBook textbook = textbookService.getTextBook(tid); 
		//courseService.delete_textbook(courseid);
		
		System.out.println("8ELW DELETE TO"+ tid);

	//	courseService.addTextBook(textbook,courseid);	
//	List<TextBook> ex_books = courseService.viewCourseTextBooks(courseid);
		
			//if(courseService.getCourse(courseid).getTextBooks().contains(textbook)) {
//		for(TextBook ex: ex_books) {
//			if(textbook.getId()==ex.getId()) {
				System.out.println("ok");
				System.out.println("ekane delete");
				
			//	Student student = studentService.getStudent(sid);
				
				
				
					//	textbookService.deleteTextBookProfile(profid);
						
				studentService.delete_textbookprofile(tid, sid);
				
				//textbookService.deleteTextBookProfile(id);
				
//			}
//		}		
				System.out.println("ekane delete");
	//	courseService.getCourse(id).setTextbooks((List<TextBook>) textbooks);
		
		return "redirect:/student/"+t;
	}
	
	@PostMapping("/{sid}/saveSelectedTextBook/{tid}")
	public String saveSelectedTextBook(@ModelAttribute("textbooks") TextBook textbooks, @PathVariable("tid") int tid, @PathVariable("sid") int sid) {
		
		Boolean flag = false;
		System.out.println("STH SAVE");

		HttpSession currentSession = request.getSession();
		int t = (int) currentSession.getAttribute("student_id");
		TextBook textbook = textbookService.getTextBook(tid); 
		
		Student student = studentService.getStudent(sid);
/*		
		TextBookProfile profile = new TextBookProfile();
		int newbookProf = 1;
		HttpSession currentSession2 = request.getSession();
		currentSession2.setAttribute("newProf",newbookProf);
		
		profile.setStudent(student);
		profile.setTextbook(textbook);
		profile.setConfirmationReceived(false);
		
		
		
		textbookService.saveTextBookProfile(profile);
		System.out.println(profile.getTextbook());
	*/	
		//////////
		
		
		HttpSession currentSession1 = request.getSession();
		int cid = (int) currentSession.getAttribute("course_id");
		
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
				}
			}	
		}
		if(flag== false) {
					
					//int newbookProf = 1;
					//HttpSession currentSession2 = request.getSession();
					//currentSession2.setAttribute("newProf",newbookProf);
					TextBookProfile profile = new TextBookProfile();
					System.out.println(profile.getId());
					TextBook newBook = textbookService.getTextBook(tid);
					System.out.println(".......sthn save");
					profile.setStudent(student);
					profile.setTextbook(newBook);
					profile.setConfirmationReceived(false);
					
					
					
					textbookService.saveTextBookProfile(profile);
			}
				
		
		
		//textbookService.getTextBook(id)
		
		return "redirect:/student/"+t;
	}  
	
	
	
	@GetMapping("/selectedTextbooks/{sid}")
	public String SelectedTextbooks(Model model , @PathVariable("sid") int sid) {

		Student student = studentService.getStudent(sid);
	//	List<TextBookProfile> texbookprofiles = textbookService.getTextBookProfiles();
		List<Course> courses = courseService.getCourses();
		List<TextBookProfile> texbookprofiles = studentService.viewStudentTextBooks(sid);
		//List<TextBook> ex_books = courseService.viewCourseTextBooks(cid);
		
		// add the teacher and courses to the model
		model.addAttribute("student",student);
		model.addAttribute("courses",courses);
		model.addAttribute("texbookprofiles",texbookprofiles);
		
		// add page title
		model.addAttribute("pageTitle", "Student's statement");
		
		return "statement";
	}
}
