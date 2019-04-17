package com.dangducluan.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dangducluan.daoimp.DepartmentImp;
@Repository
public class DepartmentDAO extends JdbcDaoSupport implements DepartmentImp{
	
	@Autowired
	public DepartmentDAO(DataSource dataSource) {
		// TODO Auto-generated constructor stub
		this.setDataSource(dataSource);
	}
	
	@Transactional
	@Override
	public void displayListDepartment() {
		// TODO Auto-generated method stub
		String sql = "select depname from department";
		//DepartmentMapper departmentMapper = new DepartmentMapper();
		List<String> listDepartmentNames = this.getJdbcTemplate().queryForList(sql,String.class);
		for(String name : listDepartmentNames) {
			System.out.println(name);
		}
	}

	@Override
	public void displayListDepartmentSearching(String name) {
		// TODO Auto-generated method stub
		String sql = "select depname from department where depname like ?";
		List<String> listDepartmentNames = this.getJdbcTemplate().queryForList(sql, String.class, "%"+name+"%");
		for(String data : listDepartmentNames)
		{
			System.out.println(data);
		}
	}
}
