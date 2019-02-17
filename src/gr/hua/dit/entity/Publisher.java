package gr.hua.dit.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="publisher")
public class Publisher {
	
	   @Id
	   @GeneratedValue(strategy=GenerationType.IDENTITY)
	   @Column(name="id")
	   private int id;
	   
	      
	      @Column(name="name_of_publisher")
	      private String publisherName;
	      
	      @OneToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	      @JoinColumn(name="username")
	      private User user;
	      
	     
	      @OneToMany(fetch=FetchType.LAZY, mappedBy="publisher", cascade= {CascadeType.PERSIST, CascadeType.MERGE,
                  CascadeType.DETACH, CascadeType.REFRESH})
	      private List<TextBook> textbooks;
	      
	      public Publisher() {
              
	      }

		public Publisher(String publisherName) {
			super();
			this.publisherName = publisherName;
		}

		public int getId() {
	              return id;
	      }

	      public void setId(int id) {
	              this.id = id;
	      }

	     
	      
	      
	      
	      public String getPublisherName() {
			return publisherName;
		}



		public void setPublisherName(String publisherName) {
			this.publisherName = publisherName;
		}



		public List<TextBook> getTextBooks() {
	           return textbooks;
	   }

	   public void setTextBooks(List<TextBook> textbooks) {
	           this.textbooks = textbooks;
	   }
	   
	   
	      
	      public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


	
	      
		   @Override
	public String toString() {
		return "Publisher [id=" + id + ", publisherName=" + publisherName + "]";
	}

		public void addTextBook(TextBook textbook) {
	           if (textbooks == null) {
	                   textbooks = new ArrayList<TextBook>();
	           }
	           textbooks.add(textbook);
	   }
}
