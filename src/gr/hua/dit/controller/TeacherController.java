package gr.hua.dit.controller;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import gr.hua.dit.entity.Course;
import gr.hua.dit.entity.Student;
import gr.hua.dit.entity.Teacher;
import gr.hua.dit.entity.TextBook;
import gr.hua.dit.entity.TextBookProfile;
import gr.hua.dit.service.CourseService;
import gr.hua.dit.service.UserService;
import gr.hua.dit.service.TextBookService;
import javax.servlet.http.HttpSession; 
import javax.servlet.http.HttpServletRequest;



@Controller
@RequestMapping("/teacher")
public class TeacherController {
	@Autowired
	private UserService teacherService;
	@Autowired
	private TextBookService textbookService;
	@Autowired
	private CourseService courseService;
	@Autowired
	private HttpServletRequest request;
	
	
	
	
	@GetMapping("/selectcourse_textbooks/{cid}")
	public String listSelectingTextBook(Model model , @PathVariable("cid") int cid) {
		
		HttpSession currentSession = request.getSession();
		int chooseOrview = (int) currentSession.getAttribute("chooseOrview");
		
			if(chooseOrview == 0) {
		
					// get textbooks from the service
					List<TextBook> textbooks = textbookService.getTextBooks();
					Boolean flag = false;
					
					Course course = courseService.getCourse(cid);	
					List<TextBook> ex_books = courseService.viewCourseTextBooks(cid); 
					List<TextBook> non_ex = new ArrayList<TextBook>();
					for(TextBook e: ex_books) {
						System.out.println(e.getId());
					}
				for (TextBook textbook: textbooks){
					flag = false;
					for(TextBook ex: ex_books) {
						if(textbook.getId()==ex.getId()) {
							//System.out.println("ok");
							flag=true;
						}
					}
					if(flag==false) {
						non_ex.add(textbook);
					}
				}
	
					// add the course and textbooks to the model
					model.addAttribute("course",course);
					model.addAttribute("textbooks",textbooks);
					model.addAttribute("existing_books",ex_books);
					model.addAttribute("non",non_ex);
					
					// add page title
					model.addAttribute("pageTitle", "List of Textbooks");
					return "teacher-select-textbook";
					
			}else if(chooseOrview == 1) {
				Course course = courseService.getCourse(cid);
				List<TextBook> ex_books = courseService.viewCourseTextBooks(cid); 
				model.addAttribute("ex_books",ex_books);
				model.addAttribute("course",course);
				
				
				// add page title
				model.addAttribute("pageTitle", "Teachers' Textbooks");
				return "statement";
				
			}
			return "redirect:/firstPage";
	}
	
	@PostMapping("/{courseid}/DeleteSelectedTextBook/{tid}")
	public String DeleteSelectedTextBook(@ModelAttribute("textbooks") TextBook textbooks, @PathVariable("tid") int tid, @PathVariable("courseid") int courseid) {
		System.out.println("STH DELETE");
		HttpSession currentSession = request.getSession();
		int t = (int) currentSession.getAttribute("teacher_id");
		
//		TextBook textbook = textbookService.getTextBook(tid); 
		//courseService.delete_textbook(courseid);
		
		System.out.println("8ELW DELETE TO"+ tid);
		
		

	//	courseService.addTextBook(textbook,courseid);	
//	List<TextBook> ex_books = courseService.viewCourseTextBooks(courseid);
		
			//if(courseService.getCourse(courseid).getTextBooks().contains(textbook)) {
//		for(TextBook ex: ex_books) {
//			if(textbook.getId()==ex.getId()) {
				System.out.println("ok");
				System.out.println("ekane delete");
				
				courseService.delete_textbook(courseid, tid);
				
				System.out.println("ekane delete");
			
//			}
//		}		
		
	//	courseService.getCourse(id).setTextbooks((List<TextBook>) textbooks);
		
		return "redirect:/teacher/"+t;
	}
	
	@PostMapping("/{courseid}/saveSelectedTextBook/{id}")
	public String saveSelectedTextBook(@ModelAttribute("textbooks") TextBook textbooks, @PathVariable("id") int id, @PathVariable("courseid") int courseid) {
		System.out.println("STH SAVE");

		HttpSession currentSession = request.getSession();
		int t = (int) currentSession.getAttribute("teacher_id");
		TextBook textbook = textbookService.getTextBook(id); 
		//courseService.delete_textbook(courseid);
		
		//System.out.println("ekane delete");
		courseService.addTextBook(textbook,courseid);	
		
			
	//	courseService.getCourse(id).setTextbooks((List<TextBook>) textbooks);
		
		return "redirect:/teacher/"+t;
	}  
	

	
	@GetMapping("/{id}/choose")
	public String listTeacherCoursesChoose(Model model , @PathVariable("id") int id) {
					System.out.println("hi");
					HttpSession currentSession = request.getSession();
					currentSession.setAttribute("teacher_id",id);
					
					int chooseOrview = 0;
					
					HttpSession currentSession1 = request.getSession();
					currentSession1.setAttribute("chooseOrview",chooseOrview);

					Teacher teacher = teacherService.getTeacher(id);
					
					List<Course> courses = courseService.getCourses();
					
					// add the teacher and courses to the model
					model.addAttribute("teacher",teacher);
					model.addAttribute("courses",courses);
					
					// add page title
					model.addAttribute("pageTitle", "Teachers' Courses");
					return "teacher-courses";
	}	
	
	@GetMapping("/{id}/view")
	public String listTeacherCoursesView(Model model , @PathVariable("id") int id) {
					System.out.println("hi");
					HttpSession currentSession = request.getSession();
					currentSession.setAttribute("teacher_id",id);

					int chooseOrview = 1;
					
					HttpSession currentSession1 = request.getSession();
					currentSession1.setAttribute("chooseOrview",chooseOrview);
					
					Teacher teacher = teacherService.getTeacher(id);
					
					List<Course> courses = courseService.getCourses();
					
					// add the teacher and courses to the model
					model.addAttribute("teacher",teacher);
					model.addAttribute("courses",courses);
					
					// add page title
					model.addAttribute("pageTitle", "Teachers' Courses");
					return "teacher-courses";
	}	
	

	

}
