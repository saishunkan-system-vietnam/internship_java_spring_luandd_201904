package com.dangducluan.test;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.dangducluan.entities.Student;

public class InsertTest {
	public static void main(String[] args) {
		try {
			Reader reader = Resources.getResourceAsReader("SQLConfigMapping.xml");
			SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
			SqlSession session = sessionFactory.openSession();
			Student student = new Student();
			student.setId(3);
			student.setName("Hoàng Ngọc Nam");
			student.setBranch("PTIT");
			student.setPercentage(100);
			student.setPhone(12345);
			student.setEmail("hoangnam96@gmail.com");
			session.insert("Student.insertStudent",student);
			session.commit();
			session.close();
			System.out.println("OK");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Error");
		}
	}
}
