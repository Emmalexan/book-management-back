package gr.hua.dit.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gr.hua.dit.dao.TextBookDAO;
import gr.hua.dit.entity.TextBook;
import gr.hua.dit.entity.TextBookProfile;

@Service
public class TextBookServiceImpl implements TextBookService {

	
	// inject the TextBookDAO
		@Autowired
		private TextBookDAO textbookDAO;
		
			
	
	
	@Override
	@Transactional
	public List<TextBook> getTextBooks() {
		// TODO Auto-generated method stub
		return textbookDAO.getTextBooks();
	}



	@Override
	@Transactional
	public void saveTextBook(TextBook textbook) {
		
		textbookDAO.saveTextBook(textbook);
	}

	@Override
	@Transactional
	public TextBook getTextBook(int id) {
		// TODO Auto-generated method stub
		return textbookDAO.getTextBook(id);
	}

	@Override
	@Transactional
	public void deleteTextBook(int id) {
		// TODO Auto-generated method stub
		textbookDAO.deleteTextBook(id);
	}


	

	@Override
	@Transactional
	public List<TextBookProfile> getTextBookProfiles() {
		return textbookDAO.getTextBookProfiles();
	}



	@Override
	@Transactional
	public TextBookProfile getTextBookProfile(int id) {
		// TODO Auto-generated method stub
		return textbookDAO.getTextBookProfile(id);
	
	}  

	@Override
	@Transactional
	public void saveTextBookProfile(TextBookProfile textbookprofile) {
		textbookDAO.saveTextBookProfile(textbookprofile);
		
	}

	@Override
	@Transactional
	public void updateTextBook(TextBook textbook) {
		textbookDAO.updateTextBook(textbook);
		
	}
	
	@Override
	@Transactional
	public void updateTextBookProfile(TextBookProfile textbookprofile) {
		textbookDAO.updateTextBookProfile(textbookprofile);
		
	}
	@Override
	@Transactional
	public void deleteTextBookProfile(int id) {
		// TODO Auto-generated method stub
		textbookDAO.deleteTextBookProfile(id);
	}

	@Override
	@Transactional
	public List<TextBookProfile> viewTextbookTextbookProfiles(int tid){
		return textbookDAO.viewTextbookTextbookProfiles(tid);
	}
}
