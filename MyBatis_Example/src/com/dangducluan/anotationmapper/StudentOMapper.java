package com.dangducluan.anotationmapper;
import java.util.List;

import com.dangducluan.entities.*;

public interface StudentOMapper {
	public List<Student> selectAllStudent();
	public Student selectStudentById(int id);
	public int insertStudent(Student student);
	public int updateStudent(Student student);
	public int deleteStudent(Student student);
}
