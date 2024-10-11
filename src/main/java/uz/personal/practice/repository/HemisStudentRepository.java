package uz.personal.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.personal.practice.domain.HemisStudent;

import java.util.List;

public interface HemisStudentRepository extends JpaRepository<HemisStudent, Integer> {

    @Query("select h from student_hemis_1 h where h.checked is null order by h.id limit 50000")
    List<HemisStudent> findAllByTypeIsNull();

    @Query(value = "select create_student_partition_info_table(?1);", nativeQuery = true)
    void createStudentPartitionIInfoTable(String tableName);

    @Query(value = "select insert_Student_data(?1,?2);", nativeQuery = true)
    void insertStudentDataEveryMonth(String tableName, String universityCode);

}
