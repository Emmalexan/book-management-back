package gr.hua.dit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import gr.hua.dit.entity.Course;
import gr.hua.dit.entity.TextBook;
import gr.hua.dit.service.CourseService;
import gr.hua.dit.service.TextBookService;

@Controller
@RequestMapping("/course")
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	
	@GetMapping("/list")
	public String listCourse(Model model) {
		
		// get courses from the service
		List<Course> courses = courseService.getCourses();
		
		// add the courses to the model
		model.addAttribute("courses",courses);
		
		// add page title
		model.addAttribute("pageTitle", "List of Courses");
		return "teacher-courses";
	}
	
	
	

}
