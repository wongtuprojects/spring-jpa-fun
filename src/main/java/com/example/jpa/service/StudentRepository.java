package com.example.jpa.service;

import com.example.jpa.bo.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentRepository extends CrudRepository<Student, Long> {
    List<Student> findByFirstName(String firstName);
}
