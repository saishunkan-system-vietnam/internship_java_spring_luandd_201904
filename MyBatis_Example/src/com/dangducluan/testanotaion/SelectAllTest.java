package com.dangducluan.testanotaion;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import com.dangducluan.entities.*;

import com.dangducluan.anotationmapper.StudentMapper;

public class SelectAllTest {
	public static void main(String[] args) {
		try {
			Reader reader = Resources.getResourceAsReader("SQLConfigMapping.xml");
			SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
			SqlSession session = sessionFactory.openSession();
			
			StudentMapper studentMapper = session.getMapper(StudentMapper.class);
			List<Student> students = studentMapper.getAll();
			System.out.println("Size : "+students.size());
			session.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
