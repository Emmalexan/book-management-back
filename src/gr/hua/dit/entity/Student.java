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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

	@Entity
	@Table(name="student")
	public class Student {
		  @Id
	      @GeneratedValue(strategy = GenerationType.IDENTITY)
	      @Column(name = "id")
	      private int id;
		  
		  @Column(name = "department")
	      private String departmentName;
	      
		  @Column(name = "number_of_pass")
	      private int passNumber;		  
		  
		  @Column(name = "current_semester")
	      private int semesterNum;
		  
/*	      @ManyToMany(fetch=FetchType.LAZY,
				   cascade= {CascadeType.PERSIST, CascadeType.MERGE,
	                       CascadeType.DETACH, CascadeType.REFRESH})    
		   @JoinTable(
				   name="student_course",
				   joinColumns=@JoinColumn(name="student_id"),
				   inverseJoinColumns=@JoinColumn(name="course_id"))
	      @JsonBackReference
	      private List<Course> courses;
	*/      
	      @OneToMany(fetch = FetchType.LAZY, mappedBy="student",
	              cascade= CascadeType.ALL)
	      @JsonBackReference
	      private List<TextBookProfile> textbookprofiles;
	      
	      @OneToOne(cascade=CascadeType.ALL)
	      @JoinColumn(name="username")
	      @JsonBackReference
	      private User user;
	      
	      public Student() {
              
	      }

		
		


		public Student(String departmentName, int passNumber, int semesterNum) {
			super();
			this.departmentName = departmentName;
			this.passNumber = passNumber;
			this.semesterNum = semesterNum;
		}





		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		

		
		public String getDepartmentName() {
			return departmentName;
		}





		public void setDepartmentName(String departmentName) {
			this.departmentName = departmentName;
		}





		public int getPassNumber() {
			return passNumber;
		}


		public void setPassNumber(int passNumber) {
			this.passNumber = passNumber;
		}
		
		public int getSemesterNum() {
			return semesterNum;
		}


		public void setSemesterNum(int semesterNum) {
			this.semesterNum = semesterNum;
		}


/*		public List<Course> getCourses() {
			return courses;
		}

		public void setCourses(List<Course> courses) {
			this.courses = courses;
		}
		
*/		

		public List<TextBookProfile> getTextbookprofiles() {
			return textbookprofiles;
		}

		public void setTextbookprofiles(List<TextBookProfile> textbookprofiles) {
			this.textbookprofiles = textbookprofiles;
		}
		
		

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}





		@Override
		public String toString() {
			return "Student [id=" + id + ", departmentName=" + departmentName + ", passNumber=" + passNumber
					+ ", semesterNum=" + semesterNum + "]";
		}

		
		public void addProfileBook(TextBookProfile textbookprofile) {
			if (textbookprofiles == null) {
				textbookprofiles = new ArrayList<TextBookProfile>();
			}
			textbookprofiles.add(textbookprofile);
		}  
	      
}
