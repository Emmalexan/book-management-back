package gr.hua.dit.dao;

import java.util.List;

import gr.hua.dit.entity.TextBook;
import gr.hua.dit.entity.TextBookProfile;

public interface TextBookDAO {
	
	public List<TextBook> getTextBooks();
	
	public void saveTextBook(TextBook textbook);
	
	public TextBook getTextBook(int id);

	public void deleteTextBook(int id);
	
	public List<TextBookProfile> getTextBookProfiles();
	
	public void saveTextBookProfile(TextBookProfile textbookprofile);
	
	public TextBookProfile getTextBookProfile(int id);

	public void updateTextBook(TextBook textbook);

	public void updateTextBookProfile(TextBookProfile textbookprofile);

	public void deleteTextBookProfile(int id);

	public List<TextBookProfile> viewTextbookTextbookProfiles(int tid);

	List<Object> ProfileTextbooks(int profileID);



//	public void addNewTextbook(String textbtitle, String textbwriting, String textbyear, String textbpublisher, String textbisbn);

	
}
