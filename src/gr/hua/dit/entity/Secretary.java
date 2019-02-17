package gr.hua.dit.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="secretary")
public class Secretary {
	
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
	      
	      
	      @OneToOne(cascade=CascadeType.ALL)
	      @JoinColumn(name="username")
	      private User user;


	      public Secretary() {
	    	  
	      }
	      
	      public Secretary(String workingState, String departmentName, int yearOfRecruitment) {
			super();
			this.workingState = workingState;
			this.departmentName = departmentName;
			this.yearOfRecruitment = yearOfRecruitment;
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

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}

		@Override
		public String toString() {
			return "Secretary [id=" + id + ", workingState=" + workingState + ", departmentName=" + departmentName
					+ ", yearOfRecruitment=" + yearOfRecruitment + "]";
		}
	      
	      
	      
	      
}

