package uz.personal.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.personal.practice.domain.HemisNotFound;
import uz.personal.practice.domain.Prof;

import java.util.List;
import java.util.Optional;

public interface ProfRepository extends JpaRepository<Prof, Integer> {

    @Query("select p from Prof p where p.pinfl = ?1 order by p.profId desc limit 1")
    Optional<Prof> findByPinfl(String pinfl);

}
