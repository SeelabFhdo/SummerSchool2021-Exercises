package de.fhdo.sepdemo.controller;

import de.fhdo.sepdemo.data.Exam;
import java.util.UUID;

/**
 * Web representation of the Exam object (note that we intentionally drop access to student details here and only access
 * the count of students as this is sufficient for the current purpose of the web application)
 */
public class ExamWeb {
    private UUID id;
    private String name;
    private int studentCount;

    public ExamWeb(Exam exam) {
        id = exam.getId();
        name = exam.getName();
        studentCount = exam.getStudents().size();
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getStudentCount() {
        return studentCount;
    }
}
