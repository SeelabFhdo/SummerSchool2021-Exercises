package de.fhdo.student.management.ExamService.service.impl;

import de.fhdo.student.management.ExamService.domain.Exam;
import de.fhdo.student.management.ExamService.domain.Student;
import de.fhdo.student.management.ExamService.repository.ExamRepository;
import de.fhdo.student.management.ExamService.service.ExamServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ExamServiceImpl implements ExamServiceI {

    private final ExamRepository examRepository;

    @Autowired
    public ExamServiceImpl(ExamRepository examRepository) {
        this.examRepository = examRepository;
    }

    @Override
    public Exam createExam(Exam exam) {
        return examRepository.save(exam);
    }

    @Override
    public Exam updateExam(Exam exam) {
        return examRepository.save(exam);
    }

    @Override
    public Exam readExam(Long id) {
        return examRepository.getById(id);
    }

    @Override
    public List<Exam> readAllExam() {
        return examRepository.findAll();
    }

    @Override
    public void deleteExam(Long id) {
        examRepository.delete(examRepository.getById(id));
    }

    @Override
    public void registerToExam(Student student, Long id) {
        Exam exam = readExam(id);
        if (exam == null)
            throw new IllegalArgumentException("Invalid exam ID: " + id);

        exam.addStudent(student);
    }
}
