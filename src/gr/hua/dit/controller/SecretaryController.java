package gr.hua.dit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import gr.hua.dit.service.UserService;
import gr.hua.dit.service.UserService;
import gr.hua.dit.service.TextBookService;
import gr.hua.dit.entity.Student;
import gr.hua.dit.entity.TextBookProfile;

@Controller
@RequestMapping("/secretary")
public class SecretaryController {
	
	@Autowired
	private UserService studentService;
	@Autowired
	private TextBookService textbookService;
	
	/*@GetMapping("/studentStatement")
	public String listStudentCourses() {
		
		
		
		return "statement-student";
	}*/
	
	
	@GetMapping("/studentStatement")
	public String listStudents(Model model) {
			
			// get students from the service
			List<Student> students = studentService.getStudents();
			
			// add the students to the model
			model.addAttribute("students",students);
			
			
			// add page title
			model.addAttribute("pageTitle", "List of Students");
			return "list-students";
	}
	
	@GetMapping("/studentProfile/{stid}")
	public String listStudentsTextBooks(Model model, @PathVariable("stid") int stid) {
		
		Student student = studentService.getStudent(stid);
		
		List<TextBookProfile> textbookprofiles = textbookService.getTextBookProfiles();
		
		model.addAttribute("stid", stid);
		model.addAttribute("student", student);
		model.addAttribute("textbookprofiles", textbookprofiles);
		model.addAttribute("pageTitle", "Student's Statement");
		
		return "receipt-textbook";
		//return "profile-student";
	}
}
	
	
	
	
	
