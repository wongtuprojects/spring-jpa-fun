package com.example.jpa.service;

import com.example.jpa.bo.Subject;
import org.springframework.data.repository.CrudRepository;

public interface SubjectRepository extends CrudRepository<Subject, Long> {
}
