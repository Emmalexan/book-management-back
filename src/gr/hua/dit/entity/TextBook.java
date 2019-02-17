package gr.hua.dit.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@XmlRootElement(name = "TextBook")
@Entity
@Table(name="textbook")
public class TextBook implements Serializable {
	
	
	private static final long serialVersionUID = 4310661683443846471L;
	
	   @Id
	   @GeneratedValue(strategy=GenerationType.IDENTITY)
	   @Column(name="id")
	   private int id;

	   @Column(name="title")
	   private String title;
	   
	   @Column(name="writer")
	   private String writer;

	   @Column(name="year_of_publishing")
	   private String year;
	   
	   @Column(name="name_of_publisher")
	   private String publishername;
	   
	   @Column(name="ISBN")
	   private String isbn;
	      
	   @Column(name="receiving_point")
	   private String receivingPoint;

	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
               CascadeType.DETACH, CascadeType.REFRESH})
	   @JoinColumn(name="publisher_id")
	   @JsonBackReference
	   private Publisher publisher;
	   
	   @ManyToMany(fetch=FetchType.LAZY,
			   cascade= {CascadeType.PERSIST, CascadeType.MERGE,
		               CascadeType.DETACH, CascadeType.REFRESH})    
	   @JoinTable(
			   name="course_textbook",
			   joinColumns=@JoinColumn(name="textbook_id"),
			   inverseJoinColumns=@JoinColumn(name="course_id"))
	   @JsonBackReference
	   private List<Course> courses;
	   
	   @OneToMany(fetch = FetchType.LAZY, mappedBy="textbook",
			   cascade=CascadeType.ALL)
	   @JsonBackReference
	      private List<TextBookProfile> textbookprofiles;
	
	   public TextBook() {
           
		   
	   }
	  
	   public TextBook(String title, String writer, String year, String publishername, String isbn, String receivingPoint) {
		super();
		this.title = title;
		this.writer = writer;
		this.year = year;
		this.publishername = publishername;
		this.isbn = isbn;
		this.receivingPoint = receivingPoint;
	}

	public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}
	   
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}
/*	
	 public TextBookProfile getTextbookProfile() {
			return textbookProfile;
		}
		public void setTextbookProfile(TextBookProfile textbookProfile) {
			this.textbookProfile = textbookProfile;
		}
*/
	public String getPublishername() {
		return publishername;
	}

	public void setPublishername(String publishername) {
		this.publishername = publishername;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	public String getReceivingPoint() {
		return receivingPoint;
	}


	public void setReceivingPoint(String receivingPoint) {
		this.receivingPoint = receivingPoint;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	
	

	public List<TextBookProfile> getTextbookprofiles() {
		return textbookprofiles;
	}

	public void setTextbookprofiles(List<TextBookProfile> textbookprofiles) {
		this.textbookprofiles = textbookprofiles;
	}

	@Override
	public String toString() {
		return "TextBook [id=" + id + ", title=" + title + ", writer=" + writer + ", year=" + year + ", publishername="
				+ publishername + ", isbn=" + isbn + ", receivingPoint=" + receivingPoint + "]";
	}
	
	

	


}
