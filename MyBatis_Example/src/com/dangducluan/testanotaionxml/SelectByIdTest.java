package com.dangducluan.testanotaionxml;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import com.dangducluan.anotationmapper.*;
import com.dangducluan.entities.Student;
public class SelectByIdTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Reader reader = Resources.getResourceAsReader("SQLConfigMapping.xml");
			SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
			SqlSession session = sessionFactory.openSession();
			StudentOMapper studentOMapper = session.getMapper(StudentOMapper.class);
			Student student = studentOMapper.selectStudentById(2);
			session.commit();
			session.close();
			System.out.println(student.getEmail());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
