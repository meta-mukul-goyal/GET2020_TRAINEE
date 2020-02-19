package com.example.demo.DaoImpl;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.example.demo.Dao.StudentDaoInterface;
import com.example.demo.model.StudentDetail;

@Repository("studentDaoObj")
public class StudentDao implements StudentDaoInterface {
	ArrayList<StudentDetail> studentList = new ArrayList<StudentDetail>();	
	
	@Override
	public void addStudent(StudentDetail sdObj) {
		studentList.add(sdObj);
	}

	@Override
	public ArrayList<StudentDetail> getAllStudent() {
		return studentList;
	}

}
