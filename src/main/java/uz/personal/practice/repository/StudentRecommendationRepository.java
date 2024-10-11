package uz.personal.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.personal.practice.domain.StudentRecommendation;

import java.util.Optional;

public interface StudentRecommendationRepository extends JpaRepository<StudentRecommendation, Integer> {

    @Query("select s from student_recommendation s where s.pinfl = ?1 order by s.id limit 1 ")
    Optional<StudentRecommendation> findStudentRecommendationByPinfl(String pinfl);
}
