package com.project.sms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.sms.dto.StudentDto;
import com.project.sms.entity.Student;
import com.project.sms.services.StudentService;

@CrossOrigin("*")
@RestController
@RequestMapping("/students")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody StudentDto studentDto){
		return ResponseEntity.ok(this.studentService.createStudent(studentDto));
	}
	
	@GetMapping("{id}")
	public ResponseEntity<?> getbyId(@PathVariable Long id){
		return ResponseEntity.ok(this.studentService.getStudentbyId(id));
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = studentService.getAllStudents();
        return ResponseEntity.ok(students);
    }
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> updatebyid(@PathVariable Long id, @RequestBody StudentDto upStudentDto){
		return ResponseEntity.ok(this.studentService.updateStu(id, upStudentDto));
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteStu(@PathVariable Long id){
		this.studentService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
