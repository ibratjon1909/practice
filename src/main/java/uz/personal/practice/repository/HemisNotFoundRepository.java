package uz.personal.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.personal.practice.domain.HemisNotFound;
import uz.personal.practice.domain.HemisStudent;

import java.util.List;

public interface HemisNotFoundRepository extends JpaRepository<HemisNotFound, Integer> {

    @Query("select h from hemis_not_found h where h.checkedProf is null order by h.id ")
    List<HemisNotFound> findAllByTypeIsNull();

}
