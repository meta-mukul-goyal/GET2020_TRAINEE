package com.example.demo.model;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class StudentDetail {
	
	@NotBlank(message="{emptyField}")
	@Size(min=2, max=20, message="{badLength}")
	private String firstName;
	
	@NotBlank(message="{emptyField}")
	@Size(min=2, max=20, message="{badLength}")
	private String lastName;
	
	@NotBlank(message="{emptyField}")
	@Size(min=2, max=20, message="{badLength}")
	private String fatherName;
	
	@NotBlank(message="{emptyField}")
	@Email(message="{badEmail}")
	private String email;
	
	private int classs;
	private int age;	
	
	public StudentDetail() {}

	public StudentDetail(String firstName, String lastName, String fatherName, String email, int classs, int age) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.fatherName = fatherName;
		this.email = email;
		this.classs = classs;
		this.age = age;
		
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
	
	public String getFatherName() {
		return fatherName;
	}
	
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public int getClasss() {
		return classs;
	}

	public void setClasss(int classs) {
		this.classs = classs;
	}

	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "StudentDetail [firstName=" + firstName + ", LastName=" + lastName + ", fatherName=" + fatherName
				+ ", email=" + email + ", classs=" + classs + ", age=" + age + "]";
	}
	
	
}
