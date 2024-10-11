package uz.personal.practice.domain;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Prof extends AbstractEntity {
    private String pinfl;
    private String full_name;
    private String university;
    private String status;
    private String eduTypeCode;
    private String eduType;
    private String  ownership;
    private Integer profId;
}
