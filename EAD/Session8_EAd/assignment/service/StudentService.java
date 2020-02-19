package com.example.demo.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DaoImpl.StudentDao;
import com.example.demo.model.StudentDetail;

@Service
public class StudentService {
	
	@Autowired
	private StudentDao studentDaoObj;
	
	public  void addStudent(StudentDetail sdObj) {
		studentDaoObj.addStudent(sdObj);
	}
	
	public ArrayList<StudentDetail> getAllStudent() {
		return studentDaoObj.getAllStudent();
	}
}
