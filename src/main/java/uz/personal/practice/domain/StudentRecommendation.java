package uz.personal.practice.domain;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "student_recommendation")
public class StudentRecommendation extends AbstractEntity {
    private String pinfl;
    private String year;
    private Integer type;
}
