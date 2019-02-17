package gr.hua.dit.entity;


	import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.io.Serializable;
	import java.sql.Timestamp;

	import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
	import javax.persistence.Table;
	import javax.persistence.Column;
	import javax.persistence.FetchType;
	import javax.persistence.JoinColumn;
	import javax.persistence.JoinColumns;
	import javax.persistence.ManyToOne;
	import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
	import javax.persistence.Embeddable;

	@Entity
	@Table(name = "user")
	@SuppressWarnings("serial")
	public class User implements Serializable {


		/*@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name = "id")
		private int id;  */
		
		@Id
		@Column(name = "username")
		private String userName;

		@Column(name = "password", nullable = false)
		private String userPassword;
		
		@Column(name = "enabled", nullable = false)
		  private boolean enabled;
		
		@Column(name = "first_name")
	      private String firstName;
	      
	      @Column(name = "last_name")
	      private String lastName;
	      
	      @Column(name="email")
	      private String email;
	      
	      @ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
	              CascadeType.DETACH, CascadeType.REFRESH})
	      @JoinColumn(name="authority")
	      private Authorities authority;

	      
	     
/*	      
	      @OneToOne(fetch=FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "user")
	      private Authorities authoritie;
*/	      
	      @OneToOne(fetch = FetchType.LAZY , mappedBy="user", cascade=CascadeType.ALL)
	        private Teacher teacher;
	      @OneToOne(fetch = FetchType.LAZY , mappedBy="user", cascade=CascadeType.ALL)
	        private Publisher publisher;
	      @OneToOne(fetch = FetchType.LAZY , mappedBy="user", cascade=CascadeType.ALL)
	        private Student student;
	      @OneToOne(fetch = FetchType.LAZY ,mappedBy="user", cascade=CascadeType.ALL)
	        private Secretary secretary;

	      public User() {};
	      public User(String userName, String userPassword, String firstName, String lastName, String email) {
				super();
				this.userName = userName;
				this.userPassword = userPassword;
				this.firstName = firstName;
				this.lastName = lastName;
				this.email = email;
			}
			
	      
	/*      public int getId() {
				return id;
			}

			public void setId(int id) {
				this.id = id;
			}
*/


		
		public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}

		public String getUserPassword() {
			return userPassword;
		}

		public void setUserPassword(String userPassword) {
			this.userPassword = userPassword;
		}


		public String getFirstName() {
			return firstName;
		}


		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}


		public String getLastName() {
			return lastName;
		}


		public void setLastName(String lastName) {
			this.lastName = lastName;
		}


		public String getEmail() {
			return email;
		}


		public void setEmail(String email) {
			this.email = email;
		}
		
/*
		public Role getRole() {
			return role;
		}
		public void setRole(Role role) {
			this.role = role;
		}
		*/
		
		public Teacher getTeacher() {
			return teacher;
		}
		public void setTeacher(Teacher teacher) {
			this.teacher = teacher;
		}
		public Publisher getPublisher() {
			return publisher;
		}
		public void setPublisher(Publisher publisher) {
			this.publisher = publisher;
		}
		public Student getStudent() {
			return student;
		}
		public void setStudent(Student student) {
			this.student = student;
		}
		public boolean isEnabled() {
			return enabled;
		}
		public void setEnabled(boolean enabled) {
			this.enabled = enabled;
		}
		
		
	/*	public Authorities getAuthoritie() {
			return authoritie;
		}
		public void setAuthoritie(Authorities authoritie) {
			this.authoritie = authoritie;
		}*/
		
		public Authorities getAuthoritie() {
			return authority;
		}
		public void setAuthoritie(Authorities authority) {
			this.authority = authority;
		}
		
		
		
		
		
		
		public Secretary getSecretary() {
			return secretary;
		}
		
		
		public void setSecretary(Secretary secretary) {
			this.secretary = secretary;
		}
		@Override
		public String toString() {
			return "User [userName=" + userName + ", userPassword=" + userPassword + ", enabled="
					+ enabled + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + "]";
		}
		
		
		
/*		@Override
		public String toString() {
			return "Users [id=" + id + ", userName=" + userName + ", userPassword=" + userPassword + ", firstName="
					+ firstName + ", lastName=" + lastName + ", email=" + email + ", role=" + role + "]";
		}

*/
		
		
		
	}

