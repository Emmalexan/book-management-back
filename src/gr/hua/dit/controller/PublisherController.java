package gr.hua.dit.controller;

import java.security.Principal;
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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import gr.hua.dit.entity.Course;
import gr.hua.dit.entity.Publisher;
import gr.hua.dit.entity.Student;
import gr.hua.dit.entity.Teacher;
import gr.hua.dit.entity.TextBook;
import gr.hua.dit.entity.TextBookProfile;
import gr.hua.dit.entity.User;
import gr.hua.dit.service.UserService;
import gr.hua.dit.service.UserService;
import gr.hua.dit.service.TextBookService;
import gr.hua.dit.service.UserService;

@Controller
@RequestMapping("/publisher")
public class PublisherController {
	
	@Autowired
	private UserService publisherService;	
	@Autowired
	private TextBookService textbookService;
	@Autowired
	private UserService studentService;
	@Autowired
	private UserService userService;
	@Autowired
	private HttpServletRequest request;
	
	
	
	@GetMapping("/mytextbooks/{id}")
	public String listPublisherTextbooks(Model model , @PathVariable("id") int id) {
					HttpSession currentSession = request.getSession();
					currentSession.setAttribute("publisher_id",id);
					
					Publisher publisher = publisherService.getPublisher(id);
					
					List<TextBook> textbooks = textbookService.getTextBooks();
					
					model.addAttribute("pub",publisher.getId());
					
					// add the publisher and textbooks to the model
					model.addAttribute("publisher",publisher);
					model.addAttribute("textbooks",textbooks);
					
					// add page title
					model.addAttribute("pageTitle", "Publishers' Textbooks");
					return "publisher-textbooks";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteTextBook(@PathVariable("id") int id, Model model) {
		
		System.out.println("mphke sth delete");
		HttpSession currentSession = request.getSession();
		int t = (int) currentSession.getAttribute("publisher_id");
		textbookService.deleteTextBook(id);
		System.out.println("bhke sth delete textbook");
		return "redirect:/publisher/mytextbooks/"+t;  
	}

	@RequestMapping(value="/findStudent", method=RequestMethod.POST)
	public String FindStudent(@RequestParam("passnum") int number,Model model) {
			System.out.println(number);
		
			List<Student> students = studentService.getStudents();
			for(int i=0; i< students.size(); i++) {
				if(students.get(i).getPassNumber() == number) {
					int sid = students.get(i).getId();
					//Student tempstudent = studentService.getStudent(sid);
				//	model.addAttribute("sid",sid);
					HttpSession currentSession = request.getSession();
					currentSession.setAttribute("student_id",sid);
					
					int t = (int) currentSession.getAttribute("student_id");
					
					
					return "redirect:/publisher/studentProfile/"+t;
				}
			}
			String message = "Δεν βρέθηκε αυτός ο αριθμός πάσου";
			HttpSession currentSession = request.getSession();
			currentSession.setAttribute("message",message);
			
		//	model.addAttribute("message",message);
			return "redirect:/publisher/students";
		}
	
	
	
	
	

	
	@GetMapping("/studentProfile/{stid}")
	public String listStudentsTextBooks(Model model, @PathVariable("stid") int stid) {
		
		Student student = studentService.getStudent(stid);
		
		List<TextBookProfile> textbookprofiles = textbookService.getTextBookProfiles();
	
		
		model.addAttribute("stid", stid);
		model.addAttribute("student", student);
		model.addAttribute("textbookprofiles", textbookprofiles);
		model.addAttribute("pageTitle", "Profile Student");
		
		return "receipt-textbook";
		//return "profile-student";
	}

	
	
	@GetMapping("/deliveryPoint/{tid}")
	public String getDeliveryForm(Model model, @PathVariable("tid") int tid) {
		
		TextBook textbook = textbookService.getTextBook(tid);
		
		//List<TextBookProfile> textbookprofiles = textbookService.getTextBookProfiles();
		
		
		model.addAttribute("textbook", textbook);
		//model.addAttribute("textbookprofiles", textbookprofiles);
		
		return "add-delivery-point";
	}

	@GetMapping("/confirmation/{stid}/{textprofid}")
	public String getConfirmationForm(Model model, @PathVariable("textprofid") int textprofid) {
		// get the textbookprofile
		
	/*	TextBookProfile textbookprofile = textbookService.getTextBookProfile(textprofid);
		
		model.addAttribute("textbookprofile", textbookprofile);
		
		return "confirmation-delivery-textbook";   */
		
		TextBookProfile textbookprofile = textbookService.getTextBookProfile(textprofid);
		if(textbookprofile.getConfirmationReceived()== false) {
			textbookprofile.setConfirmationReceived(true);
			System.out.println(textbookprofile.getConfirmationReceived());
			textbookService.updateTextBookProfile(textbookprofile);
		}
		
		return "redirect:/publisher/studentProfile/{stid}";
	}   
	

	
	
	@PostMapping("/saveTextBook/{tid}")
	public String saveTextBookProfile(@ModelAttribute("textbook") TextBook textbook, @PathVariable("tid") int tid){
		// save the textbookprofile using the service
		System.out.println("bhke sth save textbook");
		System.out.println(textbookService.getTextBook(tid).getTitle());
		System.out.println(textbookService.getTextBook(tid).getId());
		//System.out.println(textbookService.getTextBook(tid).getReceivingPoint());
		//System.out.println(textbook.getId());
		
		System.out.println(textbook.getReceivingPoint());
		
		
		TextBook newTextbook = textbookService.getTextBook(tid);
		newTextbook.setReceivingPoint(textbook.getReceivingPoint());
		
		System.out.println(newTextbook.getId());
		System.out.println(newTextbook.getReceivingPoint());
		
		
		textbookService.updateTextBook(newTextbook);
		
		HttpSession currentSession = request.getSession();
		int t = (int) currentSession.getAttribute("publisher_id");
	
		
		return "redirect:/publisher/mytextbooks/"+t;
	}
	

	
	@GetMapping("/showDeliveryPointForm")
	public String showDeliveryPointForm(Model model) {
		// create model attribute to get form data
		
		
		TextBookProfile textbookprofile = new TextBookProfile();
		model.addAttribute("textbookprofile", textbookprofile);
		
		// add page title
		model.addAttribute("pageTitle", "Add Delivery Point");
		return "add-delivery-point";
	}
	
	@GetMapping("/{id}")
	public String showAddForm(Model model, @PathVariable("id") int id) {
		// create model attribute to get form data
		Publisher publisher= publisherService.getPublisher(id);
		TextBook textbook = new TextBook();
		//textbook.setPublisher(publisher);
		model.addAttribute("pub",publisher.getId());
		model.addAttribute("idTextbook", 0);
		model.addAttribute("textbook", textbook);
		
		// add page title
		model.addAttribute("pageTitle", "Add Textbook");
		return "textbook-form";
	}  
	
	@GetMapping("/viewtextbook/{id}")
	public String getTextBook(Model model, @PathVariable("id") int id) {
		// get the textbook
		HttpSession currentSession = request.getSession();
		int t = (int) currentSession.getAttribute("publisher_id");
		TextBook textbook = textbookService.getTextBook(id);
//		Publisher publisher= publisherService.getPublisher(pub);
		//System.out.println(textbook);
	//	model.addAttribute("pub",publisher.getId());
		model.addAttribute("pub",t);
		model.addAttribute("textbook", textbook);
		model.addAttribute("idTextbook", textbook.getId());
		return "textbook-form";
	}
	
	@PostMapping("/{pub}/update/{id}")
	public String updatesTextBook(@PathVariable("id") int id,@ModelAttribute("textbook") TextBook textbook,@PathVariable("pub") int pub) {
		if(id== 0) {
			
			System.out.println("bhke sth save textbook");
			Publisher publisher = publisherService.getPublisher(pub);
			textbook.setPublisher(publisher);
			textbookService.saveTextBook(textbook);
			return "redirect:/publisher/mytextbooks/{pub}";
		}
		System.out.println(id);
		textbook.setId(id);
		Publisher publisher = publisherService.getPublisher(pub);
		textbook.setPublisher(publisher);
		textbookService.updateTextBook(textbook);
		return "redirect:/publisher/mytextbooks/{pub}";  
	} 
	
	@PostMapping("/update/{id}")
	public String updateTextBook(@PathVariable("id") int id,@ModelAttribute("textbook") TextBook textbook) {
		HttpSession currentSession = request.getSession();
		int t = (int) currentSession.getAttribute("publisher_id");
		if(id== 0) {
			
			System.out.println("bhke sth save textbook");
			Publisher publisher = publisherService.getPublisher(t);
			textbook.setPublisher(publisher);
			textbookService.saveTextBook(textbook);
			return "redirect:/publisher/mytextbooks/"+ t;
		}
		System.out.println(id);
		textbook.setId(id);
		Publisher publisher = publisherService.getPublisher(t);
		textbook.setPublisher(publisher);
		textbookService.updateTextBook(textbook);
		return "redirect:/publisher/mytextbooks/"+ t;  
	} 
	
	@GetMapping("/students")
	public String listStudents(Model model) {
		
		
		// get students from the service
		List<Student> students = studentService.getStudents();
		Student student = new Student();
		List<TextBookProfile> textbookprofiles = textbookService.getTextBookProfiles();
		// add the students to the model
		model.addAttribute("students",students);
		model.addAttribute("student",student);
		model.addAttribute("textbookprofiles",textbookprofiles);
		
		
		HttpSession current1 = request.getSession();
		int pub_id = (int) current1.getAttribute("publisher_id");
		model.addAttribute("pub_id",pub_id);
		HttpSession current2 = request.getSession();
		String message = (String) current2.getAttribute("message");
		model.addAttribute("message",message);
		// add page title
		model.addAttribute("pageTitle", "List of Students");
		return "list-students";
	}
	
	
}
