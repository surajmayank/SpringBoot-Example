package com.example.TestRestApi.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.TestRestApi.Connection.MySqlConnection;
import com.example.TestRestApi.Exception.StudentNotfoundException;
import com.example.TestRestApi.model.Student;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
public class StudentServiceImpl implements StudentService {
	Connection con;
	PreparedStatement st;
	ResultSet rs;
	Student stu;
	public static List<Student> stulist = new ArrayList<>();
	@Override
	public List<Student> findAll() {
		try {
			String sql = "select * from student";
			con = MySqlConnection.getConnection();
			st = con.prepareStatement(sql);
			rs = st.executeQuery();
			while (rs.next()) {
				stu = new Student();
				stu.setId(rs.getInt("Id"));
				stu.setName(rs.getString("Name"));
				stu.setRollNo(rs.getString("rollNo"));
				stulist.add(stu);
			}
		} catch (ClassNotFoundException | SQLException e) {
			log.error("error --- {}", e);
		}
		log.info("List of all Student --- {}", stu);
		return stulist;
	}

	@Override
	public Student findByName(String Name) {
		String sql = "select * from student where Name = ?";
		try {
			con = MySqlConnection.getConnection();
			st = con.prepareStatement(sql);
			st.setString(1, Name);
			rs = st.executeQuery();
			while (rs.next()) {
				stu = new Student();
				stu.setId(rs.getInt("Id"));
				stu.setName(rs.getString("Name"));
				stu.setRollNo(rs.getString("rollNo"));
				log.info("List of student ---- {}", stu);
			}
		} catch (ClassNotFoundException | SQLException e) {
			log.error("error --- {}", e);
		}

		return stu;
	}

	@Override
	public void postStudentDetails(Student student) {

		String sql = "insert into student values(?,?,?)";
		try {
			con = MySqlConnection.getConnection();
			st = con.prepareStatement(sql);
			st.setInt(1, student.getId());
			st.setString(2, student.getName());
			st.setString(3, student.getRollNo());
			st.executeUpdate();
			log.info("inserted successfully", st);
		} catch (ClassNotFoundException | SQLException e) {
			log.error("error --- {}", e);
		}
	}

	@Override
	public void updateStudentDetails(String name,int id) {
		
		String findsql = "select * from student where Id=?";
		 
		String sql="UPDATE student SET Name = ? WHERE Id = ?";
		try {
			con = MySqlConnection.getConnection();
			st = con.prepareStatement(findsql);
			st.setInt(1,id);
			rs = st.executeQuery();
			if(rs.next() == false) {
				throw new StudentNotfoundException();
			}
			else {
			st = con.prepareStatement(sql);
			st.setInt(2,id);
			st.setString(1,name);
			st.executeUpdate();
			log.info("updated successfully", st);
			}
		} catch (ClassNotFoundException | SQLException e) {
			log.error("error --- {}", e);
		}
	}

}
