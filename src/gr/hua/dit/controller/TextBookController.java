package gr.hua.dit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import gr.hua.dit.entity.Publisher;
import gr.hua.dit.entity.TextBook;
import gr.hua.dit.entity.TextBookProfile;
import gr.hua.dit.service.UserService;
import gr.hua.dit.service.TextBookService;


@Controller
@RequestMapping("/textbook")
public class TextBookController {
	
	// inject the customer service
		@Autowired
		private TextBookService textbookService;
		
		
		
		@GetMapping("/list")
		public String listTextBook(Model model) {
			
			// get textbooks from the service
			List<TextBook> textbooks = textbookService.getTextBooks();
			
			// add the textbooks to the model
			model.addAttribute("textbooks",textbooks);
			
			// add page title
			model.addAttribute("pageTitle", "List of Textbooks");
			return "list-textbooks";
		}
		
		@GetMapping("/{id}")
		public String getTextBook(Model model, @PathVariable("id") int id) {
			// get the textbook
			if(id == 0) {
				TextBook textbook = new TextBook();
				model.addAttribute("textbook",textbook);
				model.addAttribute("idTextbook", textbook.getId());
				return "textbook-form";
			}
			TextBook textbook = textbookService.getTextBook(id);
			//System.out.println(textbook);
			model.addAttribute("textbook", textbook);
			model.addAttribute("idTextbook", textbook.getId());
			return "textbook-form";
		}
		
		@GetMapping("/showAddForm")
		public String showAddForm(Model model) {
			// create model attribute to get form data
			TextBook textbook = new TextBook();
			model.addAttribute("textbook", textbook);
			
			// add page title
			model.addAttribute("pageTitle", "Add Textbook");
			return "textbook-form";
		}   
		
		@GetMapping("/delete/{id}")
		public String deleteTextBook(@PathVariable("id") int id, Model model) {
			textbookService.deleteTextBook(id);
			System.out.println("bhke sth delete textbook");
			return "list-textbooks";  
		}
		
		@PostMapping("/saveTextBook")
		public String saveTextBook(@ModelAttribute("textbook") TextBook textbook){
			// save the textbook using the service
			System.out.println("bhke sth save textbook");
			
			textbookService.saveTextBook(textbook);
			return "redirect:/textbook/list";
		}
		
		
	/*	@PostMapping("/update")
		public String updateTextBook(@ModelAttribute("textbook") TextBook textbook) {
			//System.out.println(textbook);
			
			String title = textbook.getTitle();
			
			
			textbookService.updateTextBook(title);
			return "list-textbooks";  
		}   */
		
		@PostMapping("/update/{id}")
		public String updateTextBook(@PathVariable("id") int id,@ModelAttribute("textbook") TextBook textbook) {
			if(id== 0) {
				
				System.out.println("bhke sth save textbook");
				
				textbookService.saveTextBook(textbook);
				return "redirect:/textbook/list";
			}
			System.out.println(id);
			textbook.setId(id);
			textbookService.updateTextBook(textbook);
			return "redirect:/textbook/list";  
		} 
		
		
		
		

}
