package uz.personal.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.personal.practice.domain.DtmStudentResult;

import java.util.Optional;

public interface DtmStudentResultRepository extends JpaRepository<DtmStudentResult, Integer> {


    @Query("select d from DtmStudentResult d where d.pinfl = ?1")
    Optional<DtmStudentResult> findByPinfl(String pinfl);
}
