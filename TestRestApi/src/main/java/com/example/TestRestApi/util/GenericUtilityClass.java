package com.example.TestRestApi.util;

import com.example.TestRestApi.model.Student;
import com.example.TestRestApi.service.StudentServiceImpl;

public class GenericUtilityClass {

	public static void main(String args[]) {

		StudentServiceImpl simpl = new StudentServiceImpl();
		Student st = new Student();
		st.setId(2);
		st.setName("monu");
		st.setRollNo("420");
		simpl.postStudentDetails(st);
	}

}
