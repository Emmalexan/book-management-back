package gr.hua.dit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import gr.hua.dit.entity.Authorities;
import gr.hua.dit.entity.TextBookProfile;
import gr.hua.dit.entity.User;
import gr.hua.dit.service.AuthoritiesService;
import gr.hua.dit.service.LoginService;
import gr.hua.dit.service.UserService;
import gr.hua.dit.service.UserService;

import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.Principal;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



@Controller
//@RequestMapping("/login")
public class LoginController {

	@Autowired
	public LoginService loginService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private AuthoritiesService authService;
	@Autowired
	private HttpServletRequest request;


	@RequestMapping("/")
	  public String index(Model model, Principal principal) {
		System.out.println("sthn index");
		model.addAttribute("pageTitle", "Welcome Page");
	    model.addAttribute("message", "Έχετε συνδεθεί ως" );
	    User user = userService.getUser(principal.getName());
	    
	    model.addAttribute("firstName",user.getFirstName());
	    System.out.println(user.getFirstName());
	    return "index";
	  }
	

	
	//@GetMapping("/showLoginForm")
	@GetMapping("/login")
	public String showForm(Model model) {
		//User userform = new User();
		//model.addAttribute("userform", userform);
		System.out.println("sthn login apo controller");
		model.addAttribute("pageTitle", "Login Page");
		return "login";
	}
	
	
	
	
	
	@GetMapping("/firstPage")
	public String showfirstpage(Model model, Principal principal) {
		//model.addAttribute("message", "You are logged in as " + principal.getName());
		
	//	List<User> users = userService.getUsers();
		
		User user = userService.getUser(principal.getName());
		//System.out.println(user.getAuthorities().get(1).getAuthority());
		
		System.out.println(user.getAuthoritie().getAuthority());
			//return"teacher-profile";
		
		if(user.getAuthoritie().getAuthority().equals("ROLE_TEACHER")) {	
			HttpSession currentSession = request.getSession();
			currentSession.setAttribute("teacher_id",user.getTeacher().getId());
			model.addAttribute("user", user);
			
			System.out.println(user.getTeacher().getId());
//			return "teacher-profile";		
		}
		else if  (user.getAuthoritie().getAuthority().equals("ROLE_PUBLISHER")) {
			HttpSession currentSession = request.getSession();
			currentSession.setAttribute("publisher_id",user.getPublisher().getId());
			model.addAttribute("user", user);
//			return "publisher-profile";		
		}
		else if(user.getAuthoritie().getAuthority().equals("ROLE_ADMIN")) {	
			
			model.addAttribute("user", user);
//			return "admin-profile";		
		}
		else if(user.getAuthoritie().getAuthority().equals("ROLE_STUDENT")) {
			HttpSession currentSession = request.getSession();
			currentSession.setAttribute("student_id",user.getStudent().getId());
			model.addAttribute("user", user);
//			return "student-profile";		
		}
		else if(user.getAuthoritie().getAuthority().equals("ROLE_SECRETARY")) {	
			HttpSession currentSession = request.getSession();
			currentSession.setAttribute("secretary_id",user.getSecretary().getId());
			model.addAttribute("user", user);
//			return "secretary-profile";		
		}else {
			System.out.println("This user has not been assigned a role");
			//return "redirect:/user/showLoginForm";  
			return "index";
		}
		model.addAttribute("pageTitle", "First Page");
		return "home-page";
		 
	}   
	
	@GetMapping("/profile")
	public String ProfilePage(Model model,  Principal principal) {
		User user = userService.getUser(principal.getName());
		//System.out.println(user.getAuthorities().get(1).getAuthority());
		
		System.out.println(user.getAuthoritie().getAuthority());
			//return"teacher-profile";
		
		if(user.getAuthoritie().getAuthority().equals("ROLE_TEACHER")) {	
			model.addAttribute("user", user);
			
			System.out.println(user.getTeacher().getId());
//			return "teacher-view-profile";		
		}
		else if  (user.getAuthoritie().getAuthority().equals("ROLE_PUBLISHER")) {
			model.addAttribute("user", user);
//			return "publisher-view-profile";		
		}
		else if(user.getAuthoritie().getAuthority().equals("ROLE_ADMIN")) {	
			model.addAttribute("user", user);
//			return "admin-view-profile";		
		}
		else if(user.getAuthoritie().getAuthority().equals("ROLE_STUDENT")) {
			model.addAttribute("user", user);
//			return "student-view-profile";		
		}
		else if(user.getAuthoritie().getAuthority().equals("ROLE_SECRETARY")) {	
			model.addAttribute("user", user);
//			return "secretary-view-profile";		
		}else {
			System.out.println("This user has not been assigned a role");
			//return "redirect:/user/showLoginForm";  
			return "index";
		}
		
		return "profile";
	}


	@GetMapping("/termsOfUse")
	public String TermsOfUsePage(Model model) {
		
		model.addAttribute("pageTitle", "Terms Of Use Page");
		return "terms-use";
	}



	

	

}
