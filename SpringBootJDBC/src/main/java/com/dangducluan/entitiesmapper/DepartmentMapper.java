package com.dangducluan.entitiesmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dangducluan.entities.Department;

public class DepartmentMapper implements RowMapper<Department>{

	@Override
	public Department mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Long depid = rs.getLong("depid");
		String depno = rs.getString("depno");
		String depname = rs.getString("depname");
		return new Department(depid, depno, depname);
	}

}
