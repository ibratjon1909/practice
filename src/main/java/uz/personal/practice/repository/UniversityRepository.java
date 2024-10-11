package uz.personal.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.personal.practice.domain.University;

import java.util.List;

public interface UniversityRepository extends JpaRepository<University, Integer> {

    @Query("select u.code from University u where u.ownership<>'10'")
    List<String> findAllUniversityCodes();
}
