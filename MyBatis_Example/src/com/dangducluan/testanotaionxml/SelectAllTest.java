package com.dangducluan.testanotaionxml;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.dangducluan.anotationmapper.StudentOMapper;
import com.dangducluan.entities.Student;

public class SelectAllTest {
	public static void main(String[] args) {
		try {
			Reader reader = Resources.getResourceAsReader("SQLConfigMapping.xml");
			SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
			SqlSession session = sessionFactory.openSession();
			StudentOMapper studentMapper = session.getMapper(StudentOMapper.class);
			
			List<Student> students = studentMapper.selectAllStudent();
			System.out.println(students.size());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
