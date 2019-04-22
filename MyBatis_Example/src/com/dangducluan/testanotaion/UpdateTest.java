package com.dangducluan.testanotaion;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.dangducluan.anotationmapper.StudentMapper;
import com.dangducluan.entities.Student;

public class UpdateTest {
	public static void main(String[] args) {
		try {
			Reader reader = Resources.getResourceAsReader("SQLConfigMapping.xml");
			SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
			SqlSession session = sessionFactory.openSession();
			StudentMapper studentMapper = session.getMapper(StudentMapper.class);
			Student student = new Student();
			student.setId(3);
			student.setName("Phan Chinh Hoang");
			student.setBranch("PTIT");
			student.setPercentage(100);
			student.setPhone(1234);
			student.setEmail("phanchinhhoang96@gmail.com");
			studentMapper.updateStudent(student);
			session.commit();
			session.close();
			System.out.println("Update ok");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Update faild");
		}
	}
}
