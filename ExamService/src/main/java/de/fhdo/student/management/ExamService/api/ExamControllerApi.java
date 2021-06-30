package de.fhdo.student.management.ExamService.api;


import de.fhdo.student.management.ExamService.domain.Exam;
import de.fhdo.student.management.ExamService.service.ExamServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/resources/v1")
public class ExamControllerApi {
    private final ExamServiceI examService;

    @Autowired
    public ExamControllerApi(ExamServiceI examService) {
        this.examService = examService;
    }

    @PostMapping(value = "/exam")
    public Exam createExam(@RequestBody @Valid Exam exam) {
        return examService.createExam(exam);
    }

    @PutMapping(value = "/exam")
    public Exam updateExam(@RequestBody @Valid Exam exam) {
        return examService.updateExam(exam);
    }

    @GetMapping(value = "/exam/{id}")
    public Exam readExam(@PathVariable Long id) {
        return examService.readExam(id);
    }

    @GetMapping(value = "/exams" )
    public List<Exam> readAllExams() {
        return examService.readAllExam();
    }

   @DeleteMapping(value = "/exam/{id}")
    public void deleteExam(@PathVariable Long id) {
        examService.deleteExam(id);
    }
}
