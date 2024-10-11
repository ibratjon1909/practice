package uz.personal.practice.domain;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.personal.practice.api_integration.hemis.StudentHemis;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
//api yordamida student ma'lumotlarini yozib olish uchun entity class
public class StudentHemisEntity extends AbstractEntity {
    private String pinfl;
    private String universityName;
    private String eduFormName;
    private String code;
    private String paymentFormCode;
    private String studentTypeCode;
    private String courseCode;
    private String groupId;
    private String socialCategoryCode;
    private String eduLanguageName;
    private String eduTypeCode;
    private String eduTypeName;
    private String specialityId;
    private String specialityCode;
    private String specialityName;
    private String countryCode;
    private String statusName;
    private String citizenshipName;
    private String course;
    private String facultyCode;
    private String updatedAt;
    private String socialCategoryName;
    private String serialAndNumber;
    private String citizenshipCode;
    private String hemisId;
    private String eduFormCode;
    private String fullName;
    private String studentTypeName;
    private String eduLanguageCode;
    private String birthDate;
    private String paymentFormName;
    private String universityCode;
    private String groupName;
    private String facultyName;
    private String countryName;
    private String statusCode;
    private String universityOwnershipCode;
    private String universityOwnershipName;
    private String accomodationCode;
    private String accomodationName;
    private String genderCode;
    private String genderName;
    private String firstName;
    private String lastName;
    private String fatherName;
    private String phoneNumber;
    private String currentEduYearCode;
    private String currentEduYear;
    private Long updateTs;
    private String gpa;

    public StudentHemisEntity(StudentHemis dto) {
        this.pinfl = dto.getPinfl();
        this.eduFormName = dto.getEduFormName();
        this.code = dto.getCode();
        this.paymentFormCode = dto.getPaymentFormCode();
        this.studentTypeCode = dto.getStudentTypeCode();
        this.socialCategoryCode = dto.getSocialCategoryCode();
        this.citizenshipName = dto.getCitizenshipName();
        this.course = dto.getCourse();
        this.updatedAt = dto.getUpdatedAt();
        this.serialAndNumber = dto.getSerialAndNumber();
        this.studentTypeName = dto.getStudentTypeName();
        this.birthDate = dto.getBirthDate();
        this.paymentFormName = dto.getPaymentFormName();
        this.universityName = dto.getUniversityName();
        this.socialCategoryName = dto.getSocialCategoryName();
        this.eduLanguageName = dto.getEduLanguageName();
        this.eduTypeName = dto.getEduTypeName();
        this.specialityId = dto.getSpecialityId();
        this.specialityCode = dto.getSpecialityCode();
        this.specialityName = dto.getSpecialityName();
        this.statusName = dto.getStatusName();
        this.citizenshipCode = dto.getCitizenshipCode();
        this.hemisId = dto.getHemisId();
        this.fullName = dto.getFullName();
    }
}
