package de.fhdo.sepdemo.controller;

import de.fhdo.sepdemo.data.Exam;
import de.fhdo.sepdemo.data.Student;
import de.fhdo.sepdemo.service.ExamService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Controller for the web application
 */
@Controller
public class WebController {
    public ExamService examService;

    public WebController(ExamService examService) {
        this.examService = examService;
    }

    /**
     * Entry point of web application
     * @param model Access to the page model (Spring MVC)
     */
    @GetMapping("/")
    public String webEntryPoint(Model model) {
        // Allow web app to access the list of all exams (i.e., communicate all found exams to the page in a model
        // attribute called "exams")
        List<ExamWeb> exams = examService.getAllExams().stream().map(ExamWeb::new).collect(Collectors.toList());
        model.addAttribute("exams", exams);
        // Return the name of the web page to display in the folder "resources/templates" without the extension ".html".
        // That is, Spring will direct the browser of the user to the web page in the file
        // "resources/templates/web.html".
        return "web";
    }

    /**
     * Entry point for the addition of a new student to an exam
     * @param model Access to the page model (Spring MVC)
     * @param examId ID of the exam to add the student to
     */
    @GetMapping("/add-student/{examId}")
    public String addStudentEntryPoint(Model model, @PathVariable UUID examId) {
        Exam exam = examService.findExamById(examId).orElse(null);
        if (exam == null)
            return "web";

        model.addAttribute("exam", exam);
        return "add-student";  // resources/templates/add-student.html
    }

    /**
     * Perform the addition of the new student via an HTTP POST request from the current web page
     * @param model Access to the page model (Spring MVC)
     * @param examId ID of the exam to add the student to
     * @param student Student object as an attribute of the page model (cf. the "th:object"-attribute in
     *                "resources/templates/add-student.html")
     * @return
     */
    @PostMapping("/add-student/{examId}")
    public String addStudent(Model model, @PathVariable UUID examId, @ModelAttribute Student student) {
        examService.registerToExam(student, examId);
        // Back to entry page (display of all exams and their student counts)
        return webEntryPoint(model);
    }
}
