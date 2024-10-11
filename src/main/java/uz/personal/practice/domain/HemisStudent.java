package uz.personal.practice.domain;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "student_hemis_1")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HemisStudent extends AbstractEntity {
    private String pinfl;
    private String createTs;
    private String updateTs;
    private String deleteTs;
    private String code;
    private String fullname;
    private String universityCode;
    private String universityName;
    private String courseCode;
    private String courseName;
    private String eduFormCode;
    private String eduFormName;
    private String eduTypeCode;
    private String eduTypeName;
    private String paymentFormCode;
    private String paymentFormName;
    private String studentStatusCode;
    private String studentStatusName;
    private String year;
    private String month;
    private Integer type;
    private Boolean checked;
    private String currentEduYearCode;
//    @Lob
//    @Column(name = "info", columnDefinition = "jsonb")
//    private String info;
}
