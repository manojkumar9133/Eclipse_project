package com.manoj.hibernate.demo.entity;

import javax.persistence.*;

@Entity
@Table(name="course")
public class Course 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="title")
	private String title;
	
	@ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinColumn(name="instructor_id")
	private Instructor insrtuctor1;
	
	public Course()
	{
		
	}
	

	public Course(String title) {
		this.title = title;
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

	public Instructor getInsrtuctor() {
		return insrtuctor1;
	}

	public void setInsrtuctor(Instructor insrtuctor) {
		this.insrtuctor1 = insrtuctor;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", title=" + title + "]";
	}
	
	
	
	

}
