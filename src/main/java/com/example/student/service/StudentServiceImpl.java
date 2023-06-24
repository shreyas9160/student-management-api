package com.example.student.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.student.exception.ResourceNotFoundException;
import com.example.student.model.Student;
import com.example.student.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public Student addStudent(Student student) {
		return studentRepository.save(student); 
	}

	@Override
	public Student updateStudent(Student student) {
		Optional<Student>stu = this.studentRepository.findById(student.getId());
		
		if(stu.isPresent()) {
			Student stu2 = stu.get();
			stu2.setId(student.getId());
			stu2.setName(student.getName());
			stu2.setCity(student.getCity());
			stu2.setState(student.getState());
			
			studentRepository.save(stu2);
			return stu2;
		}
		else {
			throw new ResourceNotFoundException();
		}
		
	}

	@Override
	public List<Student> getAll() {
		return studentRepository.findAll();
	}

	@Override
	public Student getStudentById(int id) {
		Student stu = this.studentRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException());
		
		return stu;
	}

	@Override
	public void deleteStudent(int id) {
		Optional<Student>stu = this.studentRepository.findById(id);
		if(stu.isPresent()) {
			this.studentRepository.deleteById(id);
		}
		else {
			throw new ResourceNotFoundException();
		}
		
	}

}
