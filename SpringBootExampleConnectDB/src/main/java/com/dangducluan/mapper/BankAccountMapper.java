package com.dangducluan.mapper;

import com.dangducluan.entities.*;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
public class BankAccountMapper implements RowMapper<BankAccountInfo>{

	public static final String QUERY_SQL = "select * from bank_account";
	@Override
	public BankAccountInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Long id = rs.getLong("id");
		String fullName = rs.getString("full_name");
		double balance = rs.getDouble("balance");
		return new BankAccountInfo(id, fullName, balance);
	}

	

}
