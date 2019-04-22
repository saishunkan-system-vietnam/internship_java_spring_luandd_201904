package com.dangducluan.test;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import com.dangducluan.entities.*;
import java.util.List;
public class SelectAllTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Read Config File
		try {
			Reader reader = Resources.getResourceAsReader("SQLConfigMapping.xml");
			SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
			SqlSession session = sessionFactory.openSession();
			List<Student> students = session.selectList("Student.selectAllStudent");
			for(Student x : students)
			{
				System.out.println(x.getEmail());
			}
			session.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
