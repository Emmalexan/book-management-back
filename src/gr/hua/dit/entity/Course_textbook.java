package gr.hua.dit.entity;
import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "course_textbook")
public class Course_textbook implements Serializable {

	private static final long serialVersionUID = 4310661683443846471L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "course_id")
	private int course_id;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "textbook_id")
	private int textbook_id;

	public Course_textbook() {
		
	}
	
	public Course_textbook(int course_id, int textbook_id) {
		super();
		this.course_id = course_id;
		this.textbook_id = textbook_id;
	}
	
	public int getCourse_id() {
		return course_id;
	}

	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}

	public int getTextbook_id() {
		return textbook_id;
	}

	public void setTextbook_id(int textbook_id) {
		this.textbook_id = textbook_id;
	}

	
}
