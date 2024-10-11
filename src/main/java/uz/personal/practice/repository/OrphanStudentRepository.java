package uz.personal.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.personal.practice.domain.HemisStudent;
import uz.personal.practice.domain.OrphanStudent;

import java.util.List;

public interface OrphanStudentRepository extends JpaRepository<OrphanStudent, Integer> {

    @Query("select h from OrphanStudent h where h.universityCode is not null order by h.id ")
    List<OrphanStudent> findAllByIsActiveIsNull();

}
