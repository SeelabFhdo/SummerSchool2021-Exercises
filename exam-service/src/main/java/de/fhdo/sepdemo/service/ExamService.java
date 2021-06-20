package de.fhdo.sepdemo.service;

import de.fhdo.sepdemo.data.Exam;
import de.fhdo.sepdemo.data.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ExamService {
    // Use a static list of exams for debugging purposes. In your project, you need to manage such data in a database
    // Spring Repository!
    static List<Exam> debugExams = new ArrayList<>();

    static {
        debugExams.add(new Exam("Data Structures and Algorithms"));
        debugExams.add(new Exam("Object-oriented Programming"));
    }

    public List<Exam> getAllExams() {
        return debugExams;
    }

    public Optional<Exam> findExamByName(String name) {
        return debugExams.stream().filter(e -> e.getName().equals(name)).findFirst();
    }

    public Optional<Exam> findExamById(UUID id) {
        return debugExams.stream().filter(e -> e.getId().equals(id)).findFirst();
    }

    public void registerToExam(Student student, UUID id) {
        Exam exam = findExamById(id).orElse(null);
        if (exam == null)
            throw new IllegalArgumentException("Invalid exam ID: " + id);

        exam.addStudent(student);
    }
}
