package com.example.student.service;

import java.util.List;

import com.example.student.model.Student;

public interface StudentService {
	
	Student addStudent(Student student);
	Student updateStudent(Student student);
	List<Student> getAll();
	Student getStudentById(int id);
	void deleteStudent(int id);
}
