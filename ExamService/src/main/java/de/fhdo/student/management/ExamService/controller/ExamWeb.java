package de.fhdo.student.management.ExamService.controller;

import de.fhdo.student.management.ExamService.domain.Exam;

/**
 * Web representation of the Exam object (note that we intentionally drop access to student details here and only access
 * the count of students as this is sufficient for the current purpose of the web application)
 */
public class ExamWeb {
    private final Long id;
    private final String name;
    private final int studentCount;

    public ExamWeb(Exam exam) {
        id = exam.getId();
        name = exam.getName();
        studentCount = exam.getStudents().size();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getStudentCount() {
        return studentCount;
    }
}
