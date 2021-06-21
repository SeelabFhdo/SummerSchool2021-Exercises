package de.fhdo.student.management.ExamService.service;

import de.fhdo.student.management.ExamService.domain.Exam;
import de.fhdo.student.management.ExamService.domain.Student;

import java.util.List;
import java.util.UUID;

public interface ExamServiceI {
    Exam createExam(Exam exam);
    Exam updateExam(Exam exam);
    Exam readExam(Long id);
    List<Exam> readAllExam();
    void deleteExam(Long id);
    void registerToExam(Student student, Long id);
}
