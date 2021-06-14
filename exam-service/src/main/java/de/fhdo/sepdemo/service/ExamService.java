package de.fhdo.sepdemo.service;

import de.fhdo.sepdemo.data.Exam;
import de.fhdo.sepdemo.data.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ExamService {
    public List<Exam> getAllExams() {
        return new ArrayList<Exam>();
    }

    public Optional<Exam> findExamByName(String name) {
        return null;
    }

    public Optional<Exam> findExamById(Long id) {
        return null;
    }

    public void registerToExam(Student student, Long id) {
    }
}
