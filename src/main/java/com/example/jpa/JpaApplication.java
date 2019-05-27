package com.example.jpa;

import com.example.jpa.bo.Student;
import com.example.jpa.service.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import javax.annotation.PostConstruct;

@SpringBootApplication
public class JpaApplication {

    private static final Logger log = LoggerFactory.getLogger(JpaApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(JpaApplication.class, args);


    }

    @Bean
    public CommandLineRunner checkRepo(StudentRepository studentRepository) {
       return (args) -> {
           studentRepository.save(new Student("John", "Smith"));
           studentRepository.save(new Student("Tom", "Kitedfd"));
           studentRepository.save(new Student("Harry", "Shiptuy"));

           log.info("Repo size is:" + studentRepository.count());
       };

    }

}
