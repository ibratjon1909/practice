package uz.personal.practice.domain;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class OrphanStudent extends AbstractEntity {
    private String region;
    private String district;
    private String organization;
    private String fullName;
    private String documentSerial;
    private String documentNumber;
    private String pinfl;

    private String universityCode;
    private String universityName;
    private String specialityCode;
    private String speciality;
    private String paymentForm;
    private String eduForm;
    private String eduType;
    private String course;
    private String studentStatus;

    //chetlashganlar uchun
    private String expelReason;
    private String statusOrderDate;

    //bitirganlar uchun
    private String graduatedDate;
}
