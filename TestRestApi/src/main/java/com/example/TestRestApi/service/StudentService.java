package com.example.TestRestApi.service;

import java.util.List;

import com.example.TestRestApi.model.Student;

public interface StudentService {
	public List<Student> findAll();

	public Student findByName(String Name);

	public void postStudentDetails(Student student);

	void updateStudentDetails(String name, int id);
}
