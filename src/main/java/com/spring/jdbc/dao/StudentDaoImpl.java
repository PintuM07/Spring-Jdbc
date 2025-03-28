package com.spring.jdbc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.spring.jdbc.entity.Student;

@Component("studentDao")
public class StudentDaoImpl implements StudentDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public int insert(Student student) {
		// insert query
		String query = "insert into student(id,name,address) values(?,?,?)";
		int r = this.jdbcTemplate.update(query, student.getId(), student.getName(), student.getAddress());
		return r;
	}

	@Override
	public int change(Student student) {
		// updating data
		String query = "update student set name=?, address=? where id=?";
		int r = this.jdbcTemplate.update(query, student.getName(), student.getAddress(), student.getId());
		return r;
	}

	@Override
	public int delete(int studentId) {
		String query = "delete from student where id=?";
		int r = this.jdbcTemplate.update(query, studentId);

		return r;
	}

	@Override
	public Student getStudent(int studentId) {

		String query= "select * from student where id=?";
		RowMapper<Student> rowMapper= new RowMapperImpl(); 
		Student student = this.jdbcTemplate.queryForObject(query, rowMapper, studentId);
		return student;
	}

	@Override
	public List<Student> listOfStudent() {
		//selecting all students
		String query="select *  from student";
		List<Student> students = this.jdbcTemplate.query(query, new RowMapperImpl());
		return students;
	}

}
