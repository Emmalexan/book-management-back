package gr.hua.dit.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@XmlRootElement(name = "TextBookProfile")
@Entity
@Table(name="textbook_profile")
public class TextBookProfile implements Serializable{
	
	private static final long serialVersionUID = 4310661683443846471L;

	   @Id
	   @GeneratedValue(strategy=GenerationType.IDENTITY)
	   @Column(name="id")
	   private int id;

	   
	   
	   @Column(name="confirmation_received")
	   private Boolean confirmationReceived;

	

//	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
    @ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name="textbook_id")
    
	private TextBook textbook;
    
    
    @ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name="student_id")
    
    private Student student;

    public TextBookProfile() {
    	
    }



	public TextBookProfile(String receivingPoint, Boolean confirmationReceived, String year) {
		super();
		this.confirmationReceived = confirmationReceived;
	
	}



	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Boolean getConfirmationReceived() {
		return confirmationReceived;
	}


	public void setConfirmationReceived(Boolean confirmationReceived) {
		this.confirmationReceived = confirmationReceived;
	}



	public TextBook getTextbook() {
		return textbook;
	}



	public void setTextbook(TextBook textbook) {
		this.textbook = textbook;
	}



	public Student getStudent() {
		return student;
	}



	public void setStudent(Student student) {
		this.student = student;
	}



	@Override
	public String toString() {
		return "TextBookProfile [id=" + id + ", confirmationReceived="
				+ confirmationReceived +  "]";
	}  
    
    
	
	
}
