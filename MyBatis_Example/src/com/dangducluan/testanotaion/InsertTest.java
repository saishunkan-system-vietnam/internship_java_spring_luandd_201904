package com.dangducluan.testanotaion;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.dangducluan.anotationmapper.StudentMapper;
import com.dangducluan.entities.Student;

public class InsertTest {
	public static void main(String[] args) {
		try {
			Reader reader = Resources.getResourceAsReader("SQLConfigMapping.xml");
			SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
			SqlSession session = sessionFactory.openSession();
			StudentMapper studentMapper = session.getMapper(StudentMapper.class);
			Student student = new Student();
			student.setId(3);
			student.setName("Nguyen Van Khoa");
			student.setBranch("PTIT");
			student.setPercentage(100);
			student.setPhone(12345);
			student.setEmail("khoanguyen96@gmail.com");
			studentMapper.insertStudent(student);
			session.commit();
			session.close();
			System.out.println("Insert ok");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Insert faild");
		}
	}
}
