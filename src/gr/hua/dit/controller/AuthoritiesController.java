package gr.hua.dit.controller;

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
import org.springframework.web.bind.annotation.RequestParam;

import gr.hua.dit.entity.Authorities;
import gr.hua.dit.entity.Function;
import gr.hua.dit.entity.Student;
import gr.hua.dit.entity.Teacher;
import gr.hua.dit.entity.User;
import gr.hua.dit.service.AuthoritiesService;

import gr.hua.dit.service.UserService;



@Controller
@RequestMapping("/authorities")
public class AuthoritiesController {
	@Autowired
	private AuthoritiesService authoritiesService;
	@Autowired
	private UserService userService;
	
	@Autowired
	private HttpServletRequest request;
	
	@GetMapping("/listrole")
	public String listRole(Model model) {
		
		// get users from the service
		List<Authorities> roles = authoritiesService.getAuthorities();
		
		// add the users to the model
		model.addAttribute("roles",roles);
		
		// add page title
		model.addAttribute("pageTitle", "List of Roles");
		return "list-role";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteRole(@PathVariable("id") String authority, Model model) {
		System.out.println("the" + authority);
		Authorities auth = authoritiesService.getAuthoritie(authority);
		
		List<User> users = userService.getUsers();
		
		for(int i=0; i <users.size(); i++) {
			
			
		if(users.get(i).getAuthoritie().getAuthority() != "null") {
		System.out.println("then einai keno");
		
			if(users.get(i).getAuthoritie().getAuthority().equals(authority)) {
				System.out.println("mphke" + users.get(i).getAuthoritie().getAuthority());
				User tempuser = userService.getUser(users.get(i).getUserName());
				//Authorities author = new Authorities();
				
				Authorities author = authoritiesService.getAuthoritie("null");
				System.out.println(author.getAuthority());
				
				tempuser.setUserName(users.get(i).getUserName());
				tempuser.setAuthoritie(author);
				userService.updateUser(tempuser);
				break;
			}
		}
		}
		
		authoritiesService.deleteAuthoritie(authority);
		System.out.println("bhke sth delete auth");
		
		return "redirect:/authorities/listrole";  
	}
	
	
	
	
	

	@PostMapping("/saveRole/{username}")
	public String saveRole(@RequestParam String authority, Model model,@ModelAttribute("auth") Authorities auth, @PathVariable("username") String username){

		System.out.println("HIIII");
		User user = userService.getUser(username);
		System.out.println(authority +"to onoma toy authority");
		
		Authorities tempRole = new Authorities();
		tempRole.setAuthority(authority);
		
		System.out.println(tempRole.getAuthority());
		
		user.setAuthoritie(tempRole);
		userService.updateUser(user);
		
		
		HttpSession currentSession = request.getSession();
		currentSession.setAttribute("username",username);
		String t =(String) currentSession.getAttribute("username");
		
//		return "redirect:/user/listuser";
		return "redirect:/user/ShowDetailsForm/"+t;
	}
	
/*	@GetMapping("/{autority}")
	public String getRole(Model model, @PathVariable("autority") String autority) {
		// get the user
		Authorities role = authoritiesService.getAuthoritie(autority);
		
		model.addAttribute("role", role);
		
		return "role-form";
	}*/
	
	@GetMapping("/{autority}")
	public String getRole(Model model, @PathVariable("autority") String autority) {
		// get the user
		//int newRole = 0;
		Authorities role = authoritiesService.getAuthoritie(autority);
		
		model.addAttribute("role", role);
	//	model.addAttribute("id", id);
	//	System.out.println(id);
		
		return "add-role-form";
	}   
	
	@GetMapping("/showRoleForm")
	public String showRoleForm(Model model) {
		// create model attribute to get form data
		Authorities role = new Authorities();
		//int id = role.getId();
		
		//System.out.println(id);
		
		model.addAttribute("role", role);
	//	model.addAttribute("id", id);
		// add page title
		model.addAttribute("pageTitle", "Add Role");
		return "add-role-form";
	} 
	
	
	
	
	@PostMapping("/saveRole")
	public String saveRole(Model model,@ModelAttribute("role")Authorities  role){
		
		//int roleid = role.getId();
		List<Authorities> roles = authoritiesService.getAuthorities();
		for(Authorities r : roles) {
			if(r.getAuthority().equals(role.getAuthority())) {
				model.addAttribute("message", "This Role already exist " + role.getAuthority());
				return "error";
			}
		}
		
		
			System.out.println("bhke sth save role");
			System.out.println(role.getAuthority());
			
			Authorities temprole = new Authorities();
			String namer = role.getAuthority();
			temprole.setAuthority(namer);;
			
			authoritiesService.saveAuthoritie(temprole);
		
		
		
		return "redirect:/authorities/listrole";
	}
	
	@GetMapping("/showRoleForm/{username}")
	public String showRoleForm(Model model,@PathVariable("username") String username) {
		// create model attribute to get form data
		
	//	Authorities role = new Authorities();
		List<Authorities> auths = authoritiesService.getAuthorities();
		Authorities auth = new Authorities();
		model.addAttribute("auth", auth);
		model.addAttribute("auths", auths);
		model.addAttribute("username", username);
		
		// add page title
		model.addAttribute("pageTitle", "Add Role to User");
		return "role-form";
	}  

}
