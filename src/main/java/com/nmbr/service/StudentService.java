package com.nmbr.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.nmbr.entities.Student;
import com.nmbr.repository.StudentRepo;

@Service
public class StudentService {

//	public static List<Student> list = new ArrayList<Student>();
//	
//	static {
//		list.add(new Student("Sonu",12));
//		list.add(new Student("Ankit", 10));
//	}
	@Autowired
	private StudentRepo studentRepo;
	
	// get all student details
	public List<Student> getAllStudents(){
		List<Student> list = (List<Student>) this.studentRepo.findAll();
		return list;
	}
	// get single student
	public Student getStudent(int id) {
		Student student=null;
		try {
			//student = list.stream().filter(s -> s.getStudent_id()==id).findAny().get();
			 student = this.studentRepo.getStudentById(id);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return student;
	}
	
	// Creating/adding new Student details
	
	public Student addStudent(Student s) {
		Student save = this.studentRepo.save(s);
		return save;
	}
	
	// Deleting Student details
	public void deleteStudent(int sid) {
		//list = list.stream().filter(s -> s.getStudent_id()!=sid).collect(Collectors.toList());
		this.studentRepo.deleteById(sid);
		
	}
	
	//update Student details by id
	public void updateStudentById(Student student,int upid) {
	/*	list.stream().map(s -> {
			if(s.getStudent_id()==upid) {
				s.setStudent_name(student.getStudent_name());
			}
			return s;
		}).collect(Collectors.toList());
		
	}*/
		student.setStudent_id(upid);
		
		this.studentRepo.save(student);
	}	
}
