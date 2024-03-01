package com.project.sms.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.sms.dto.StudentDto;
import com.project.sms.entity.Student;
import com.project.sms.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	public Student createStudent(StudentDto studentDto) {
		Student student = new Student();
		student.setFirstName(studentDto.getFirstName());
		student.setLastName(studentDto.getLastName());
		student.setEmail(studentDto.getEmail());
		student.setAge(studentDto.getAge());
		student.setDepartment(studentDto.getDepartment());
		this.studentRepository.save(student);
		
		return student;
	}
	
	public Student getStudentbyId(long id) {
		Student student=new Student();
		student = this.studentRepository.findById(id).orElse(null);
		return student;
	}
	
	
	public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
	
	public Student updateStu(long id , StudentDto updateDto) {
		Student student = getStudentbyId(id);
		
		if(updateDto.getFirstName() !=null) {
			student.setFirstName(updateDto.getFirstName());
		}
		
		if(updateDto.getLastName() !=null) {
			student.setLastName(updateDto.getLastName());
		}
		
		if(updateDto.getEmail() !=null) {
			student.setEmail(updateDto.getEmail());
		}
		
		if(updateDto.getAge() !=null) {
			student.setAge(updateDto.getAge());
		}
		if(updateDto.getDepartment() !=null) {
			student.setDepartment(updateDto.getDepartment());
		}
		
		this.studentRepository.save(student);
		return student;
	}
	
	public void delete(long id) {
		Student student=getStudentbyId(id);
		this.studentRepository.delete(student);
	}
}
