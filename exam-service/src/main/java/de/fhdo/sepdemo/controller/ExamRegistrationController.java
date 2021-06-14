package de.fhdo.sepdemo.controller;

import de.fhdo.sepdemo.data.Student;
import de.fhdo.sepdemo.service.ExamService;
import de.fhdo.sepdemo.data.Exam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

// The controller maps all requests from the relative URL /examservice
// E.g. https://localhost:8080/examservice
@RestController
@RequestMapping("/examservice")
public class ExamRegistrationController {
    // In a neatly organized spring project the business logic is accessed through a service
    public ExamService examService;

    // This automatically injects the dependency
    @Autowired
    public ExamRegistrationController(ExamService examService) {
        this.examService = examService;
    }
    // Handler method to deal with incoming GET requests at /examservice/exams
    // E.g. https://localhost:8080/examservice/exam
    @GetMapping("/exams")
    public List<Exam> getAllExams() {
        return examService.getAllExams();
    }
    // Find a specific exam by its name using a GET parameter
    // E.g. https://localhost:8080/examservice/exam?name=SEP
    @GetMapping("/exam")
    public Optional<Exam> findExamByName(@RequestParam String name) {
        return examService.findExamByName(name);
    }

    // Find a specific exam by its Id using the actual path
    // E.g. https://localhost:8080/examservice/exam/42
    @GetMapping("/exam/{id}")
    public Optional<Exam> findExamById(@PathVariable Long id) {
        return examService.findExamById(id);
    }

    // Let's register a new student to an exam the PostMapping
    // Therefore, the student to register needs to be send to the service
    // through the requestbody, i.e. as a serialized JSON-object
    // thankfully JSON objects are automatically converted by Spring to the corresponding
    // objects of the given class
    // E.g. https://localhost:8080/examservice/exam/42/update
    @GetMapping("/exam/{id}/update")
    public void updateExam(@RequestBody Student student, @PathVariable Long id) {
        examService.registerToExam(student, id);
    }

}

