package de.fhdo.student.management.ExamService.repository;

import de.fhdo.student.management.ExamService.domain.Exam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamRepository extends JpaRepository<Exam, Long> {
}
