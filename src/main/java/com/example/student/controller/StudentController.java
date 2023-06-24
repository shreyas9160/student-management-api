package com.example.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.student.model.Student;
import com.example.student.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@PostMapping("/create")
	public ResponseEntity<Student> createStudent(@RequestBody Student student){
		return ResponseEntity.ok().body(studentService.addStudent(student));
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable int id, @RequestBody Student student){
		student.setId(id);
		return ResponseEntity.ok().body(studentService.updateStudent(student));
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Student>> getAll(){
		return ResponseEntity.ok().body(studentService.getAll());
	}
	
	@GetMapping("/getbyId/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable int id){
		return ResponseEntity.ok().body(studentService.getStudentById(id));
	}
	
	@DeleteMapping("/delete/{id}")
	public HttpStatus deleteStudent(@PathVariable int id){
		this.studentService.deleteStudent(id);
		return HttpStatus.OK;
	}
	
}
