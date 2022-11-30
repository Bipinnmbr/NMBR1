package com.nmbr.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nmbr.entities.Student;
@Repository
public interface StudentRepo extends CrudRepository<Student, Integer> {

	public Student getStudentById(int id);
}
