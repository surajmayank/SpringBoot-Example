package com.example.TestRestApi.model;

public class Student {
	private int Id;
	private String Name;
	private String rollNo;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getRollNo() {
		return rollNo;
	}
	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}
	@Override
	public String toString() {
		return "Student [Id=" + Id + ", Name=" + Name + ", rollNo=" + rollNo + "]";
	}
	
}
