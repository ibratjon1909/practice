package uz.personal.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.personal.practice.domain.StudentSchoolData;

import java.util.List;

public interface StudentSchoolDataRepository extends JpaRepository<StudentSchoolData, Integer> {
    @Query("select s from StudentSchoolData s where s.isActive is null order by s.id ")
    List<StudentSchoolData> findAllByIsActiveIsNull();

    @Query("select s from StudentSchoolData s where s.isActive is null and s.universityCode is not null order by s.id")
    List<StudentSchoolData> findAllByIsActiveIsNotNull();
}
