package com.example.demo.Dao;

import java.util.ArrayList;

import com.example.demo.model.StudentDetail;

public interface StudentDaoInterface {
	
	 void addStudent(StudentDetail sdObj);
	 
	 ArrayList<StudentDetail> getAllStudent();

}
