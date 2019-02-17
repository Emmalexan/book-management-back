package gr.hua.dit.service;

import java.util.List;

import gr.hua.dit.entity.TextBook;
import gr.hua.dit.entity.TextBookProfile;

public interface TextBookService {
	
	public List<TextBook> getTextBooks();
	
	public void saveTextBook(TextBook textbook);
	
	public TextBook getTextBook(int id);

	public void deleteTextBook(int id);
	
	public List<TextBookProfile> getTextBookProfiles();
	
	public TextBookProfile getTextBookProfile(int id);

	public void saveTextBookProfile(TextBookProfile textbookprofile);

	public void updateTextBook(TextBook textbook);

	public void updateTextBookProfile(TextBookProfile textbookprofile);

	public void deleteTextBookProfile(int id);

	public List<TextBookProfile> viewTextbookTextbookProfiles(int tid);
	
	
}
