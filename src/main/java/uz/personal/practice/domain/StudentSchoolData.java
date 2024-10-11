package uz.personal.practice.domain;

import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.FieldDefaults;

import static lombok.AccessLevel.PRIVATE;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@FieldDefaults(level = PRIVATE)
public class StudentSchoolData extends AbstractEntity {

    String region;
    String district;
    String school;
    String schoolTin;
    String studentClass;
    String fullName;
    String birthDate;
    String serialAndNumber;
    String pinfl;
    Double result;
    String universityCode;
    String university;
    String eduForm;
    String specialityCode;
    String speciality;
    String paymentForm;
    String status;

}
