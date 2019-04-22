package com.dangducluan.test;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.dangducluan.entities.Student;

public class UpdateTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Reader reader = Resources.getResourceAsReader("SQLConfigMapping.xml");
			SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
			SqlSession session = sessionFactory.openSession();
			Student student = new Student();
			student.setId(3);
			student.setName("Nguyen Van Khoa");
			student.setBranch("PTIT");
			student.setPercentage(100);
			student.setPhone(1234560);
			student.setEmail("khoanguyen96@gmail.com");
			session.update("Student.updateStudent", student);
			session.commit();
			session.close();
			System.out.println("Update ok");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Update not done");
		}
	}

}
