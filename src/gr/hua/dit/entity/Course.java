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
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "course")
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "title")
	private String title;

	@Column(name = "semester")
	private int semester;

	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name = "teacher_id")
//	@JsonBackReference
	private Teacher teacher;

	 
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "course_textbook", joinColumns = @JoinColumn(name = "course_id"), inverseJoinColumns = @JoinColumn(name = "textbook_id"))
	@JsonBackReference
	private List<TextBook> textbooks;

	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH,
			CascadeType.REFRESH })
	@JoinTable(name = "student_course", joinColumns = @JoinColumn(name = "course_id"), inverseJoinColumns = @JoinColumn(name = "student_id"))
	@JsonBackReference
	private List<Student> students;

	// define constructors
	public Course() {

	}

	public Course(String title, int semester) {
		super();
		this.title = title;
		this.semester = semester;
	}

	// define getters and setters
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

	public int getSemester() {
		return semester;
	}

	public void setSemester(int semester) {
		this.semester = semester;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public List<TextBook> getTextBooks() {
		return textbooks;
	}

	public void setTextbooks(List<TextBook> textbooks) {
		this.textbooks = textbooks;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	// define toString
	@Override
	public String toString() {
		return "Course [id=" + id + ", title=" + title + ", semester=" + semester + "]";
	}

	public void addTextBook(TextBook textbook) {
		if (textbooks == null) {
			textbooks = new ArrayList<TextBook>();
		}
		textbooks.add(textbook);
	}
 
	   
}
