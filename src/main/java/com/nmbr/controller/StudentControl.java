package com.nmbr.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nmbr.entities.Student;
import com.nmbr.service.StudentService;

@RestController
public class StudentControl {

	@Autowired
	private StudentService studentService;
	
	//Getting all student details handler
	@GetMapping("/students")
	public ResponseEntity<List<Student>> getAllStudents() {
		
		List<Student> allStudents = this.studentService.getAllStudents();
		if(allStudents.size()<=0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(allStudents));
	}
	// getting single student detail handler
	@GetMapping("/students/{id}")
	public ResponseEntity<Student> getStudent(@PathVariable("id") int id) {
	   Student student = studentService.getStudent(id);
	   if(student==null) {
		   return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	   }
	return ResponseEntity.of(Optional.of(student));
	}
	
	// adding new student handler
	@PostMapping("/students")
	public ResponseEntity<Student> addStudent(@RequestBody Student student) {
		Student s=null;
		try {
			  s = studentService.addStudent(student);
			  return ResponseEntity.of(Optional.of(s));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}	
	}
	
	// deleting user handler
	@DeleteMapping("/students/{sid}")
	public ResponseEntity<Void> deleteStudent(@PathVariable("sid") int sid) {
		
		try {
			this.studentService.deleteStudent(sid);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	// update handler
	@PutMapping("/students/{upid}")
	public ResponseEntity<Student> updateStudentById(@RequestBody Student student,@PathVariable("upid") int upid) {
		try {
			studentService.updateStudentById(student,upid);
			return ResponseEntity.ok().body(student);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}
	
	
}
