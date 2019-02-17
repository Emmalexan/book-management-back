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

@Entity
@Table(name="teacher")
public class Teacher {
	  @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      @Column(name = "id")
      private int id;
      
      @Column(name="working_state")
      private String workingState;
      
      @Column(name="department")
      private String departmentName;
      
      @Column(name="year_of_recruitment")
      private int yearOfRecruitment;
      
      @Column(name="field_of_study")
      private String fieldOfStudy;
      
      
      @OneToMany( mappedBy="teacher",
    		  cascade= {CascadeType.PERSIST, CascadeType.MERGE,
                      CascadeType.DETACH, CascadeType.REFRESH})
      private List<Course> courses;
      
      @OneToOne(cascade=CascadeType.ALL)
      @JoinColumn(name="username")
      private User user;
      
      public Teacher() {
              
      }

    

      public Teacher(String firstName, String lastName, String email, String workingState, String departmentName,
			int yearOfRecruitment, String fieldOfStudy) {
		super();
		this.workingState = workingState;
		this.departmentName = departmentName;
		this.yearOfRecruitment = yearOfRecruitment;
		this.fieldOfStudy = fieldOfStudy;
		
	}



	public int getId() {
              return id;
      }

      public void setId(int id) {
              this.id = id;
      }

      
      

      public String getWorkingState() {
		return workingState;
	}



	public void setWorkingState(String workingState) {
		this.workingState = workingState;
	}



	public String getDepartmentName() {
		return departmentName;
	}



	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}



	public int getYearOfRecruitment() {
		return yearOfRecruitment;
	}



	public void setYearOfRecruitment(int yearOfRecruitment) {
		this.yearOfRecruitment = yearOfRecruitment;
	}



	public String getFieldOfStudy() {
		return fieldOfStudy;
	}



	public void setFieldOfStudy(String fieldOfStudy) {
		this.fieldOfStudy = fieldOfStudy;
	}



	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}



	public List<Course> getCourses() {
          return courses;
  }

  public void setCourses(List<Course> courses) {
          this.courses = courses;
  }
  
  // add convenience methods for bi-directional relation
  public void add(Course acourse) {
          if(courses == null) {
                  courses = new ArrayList<Course>();
          }
          courses.add(acourse);
          acourse.setTeacher(this);
  }



@Override
public String toString() {
	return "Teacher [id=" + id + ", workingState=" + workingState + ", departmentName=" + departmentName + ", yearOfRecruitment="
			+ yearOfRecruitment + ", fieldOfStudy=" + fieldOfStudy + "]";
}
      

}
