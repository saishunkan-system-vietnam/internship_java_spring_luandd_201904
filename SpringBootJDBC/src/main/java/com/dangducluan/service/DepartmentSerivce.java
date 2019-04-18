package com.dangducluan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dangducluan.dao.DepartmentDAO;
import com.dangducluan.daoimp.*;
@Service
public class DepartmentSerivce implements DepartmentImp{

	@Autowired
	DepartmentDAO departmentDAO;
	@Override
	public void displayListDepartment() {
		// TODO Auto-generated method stub
		departmentDAO.displayListDepartment();
	}
	@Override
	public void displayListDepartmentSearching(String name) {
		// TODO Auto-generated method stub
		departmentDAO.displayListDepartmentSearching(name);
	}

}
