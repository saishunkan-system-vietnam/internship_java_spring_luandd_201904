package com.dangducluan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dangducluan.dao.StudentDAO;
import com.dangducluan.daoimp.StudentImp;
import com.dangducluan.entities.Student;

@Service
public class StudentService implements StudentImp{

	@Autowired
	StudentDAO studentDAO;
	
	@Override
	public List<Student> getAllListStudent() {
		// TODO Auto-generated method stub
		return studentDAO.getAllListStudent();
	}

}
