package com.example.jpa;

import com.example.jpa.bo.Student;
import com.example.jpa.bo.Subject;
import com.example.jpa.service.StudentRepository;
import com.example.jpa.service.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class JpaApplication {

    private static final Logger log = LoggerFactory.getLogger(JpaApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(JpaApplication.class, args);


    }

    @Bean
    public CommandLineRunner checkRepo(StudentRepository studentRepository, SubjectRepository subjectRepository) {
       return (args) -> {
           studentRepository.save(new Student("John", "Smith"));
           studentRepository.save(new Student("Tom", "Kitedfd"));
           studentRepository.save(new Student("Harry", "Shiptuy"));

           log.info("Repo size is:" + studentRepository.count());
           log.info("deleting all records: " );
           //delete all operations
           studentRepository.deleteAll();
           //test for students with subject
           Subject subject1= new Subject("History");
           List<Subject> subjectList = new ArrayList<>();
           subjectList.add(subject1);
           Student student1 = new Student("John", "Smith", subjectList);

           studentRepository.save(student1);

           log.info("Repo size is:" + studentRepository.count());

           List<Student> studentList =  studentRepository.findByFirstName("John");
           studentList.forEach(student -> log.info(student.getSubject().get(0).getName()));
       };

    }

}
