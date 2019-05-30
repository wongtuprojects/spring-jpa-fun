package com.example.jpa.bo;

import javax.persistence.*;

@Entity
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long subjectId;
    private String name;

    public Subject(String name) {
        this.name = name;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    private Student student;

    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
