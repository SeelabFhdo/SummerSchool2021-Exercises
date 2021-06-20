package de.fhdo.sepdemo.data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Exam {
    private UUID id;
    private String name;
    private List<Student> students = new ArrayList<>();

    //constructor
    public Exam(String name) {
        this.id = UUID.randomUUID();
        this.name = name;
    }

    //Getters and setters
    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addStudent(Student s) {
        students.add(s);
    }

    public List<Student> getStudents() {
        return students;
    }
}
