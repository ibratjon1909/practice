package uz.personal.practice.domain;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "hemis_not_found")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HemisNotFound extends AbstractEntity {
    private String pinfl;
    private String hashId;
    private String fullName;
    private String universityName;

    private String universityCodeInHemis;
    private String universityInHemis;
    private String statusInHemis;
    private String paymentFormCode;
    private Boolean checkedOliy;

    private String universityInProf;
    private String statusInProf;
    private String eduTypeInProf;
    private Boolean checkedProf;

}
