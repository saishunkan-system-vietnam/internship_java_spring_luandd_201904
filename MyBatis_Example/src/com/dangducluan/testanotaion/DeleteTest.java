package com.dangducluan.testanotaion;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.dangducluan.anotationmapper.StudentMapper;

public class DeleteTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Reader reader = Resources.getResourceAsReader("SQLConfigMapping.xml");
			SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
			SqlSession session = sessionFactory.openSession();
			StudentMapper studentMapper = session.getMapper(StudentMapper.class);
			studentMapper.deleteStudent(3);
			session.commit();
			session.close();
			System.out.println("Delete ok");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Delete faild");
		}
	}

}
