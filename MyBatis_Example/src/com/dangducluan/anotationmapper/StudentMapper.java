package com.dangducluan.anotationmapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.dangducluan.entities.Student;
public interface StudentMapper {
	// get all student
	public final String GET_ALL_STUDENT = "select * from student";
	@Select(value = GET_ALL_STUDENT)
	@Results(value = {
			@Result(property = "id",column = "ID"),
			@Result(property = "name",column = "NAME"),
			@Result(property = "branch",column = "BRANCH"),
			@Result(property = "percentage",column = "PERCENTAGE"),
			@Result(property = "phone", column = "PHONE"),
			@Result(property = "email", column = "EMAIL")
			
	})
	public List<Student> getAll();
	// get student by id
	public final String GET_STUDENT_BY_ID = "select * from student where id = #{id}";
	@Select(value = GET_STUDENT_BY_ID)
	public Student getStudentById(int id);
	
	// insert student
	public final String INSERT_STUDENT = "insert into student(id,name,branch,percentage,phone,email) values(#{id},#{name},#{branch},#{percentage},#{phone},#{email})";
	@Insert(value = INSERT_STUDENT)
	@Options(useGeneratedKeys = true)
	public void insertStudent(Student student);
	
	// update student
	public final String UPDATE_STUDENT = "update student set name = #{name}, branch = #{branch}, percentage = #{percentage}, phone = #{phone}, email = #{email} where id = #{id}";
	@Update(value = UPDATE_STUDENT)
	public void updateStudent(Student student);
	
	// delete student
	public final String DELETE_STUDENT = "delete from student where id = #{id}";
	@Delete(value = DELETE_STUDENT)
	public void deleteStudent(int id);
}
