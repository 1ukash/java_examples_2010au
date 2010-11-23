package ru.spbstu.telematics.stud.streams;

import java.io.Serializable;

public class Person implements Serializable {
	private static final long serialVersionUID = -523894115375116742L;
	
	private String name, id, place;
	private int age;
	
	public Person(String name, String id, String place, int age) {
		super();
		this.name = name;
		this.id = id;
		this.place = place;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}
