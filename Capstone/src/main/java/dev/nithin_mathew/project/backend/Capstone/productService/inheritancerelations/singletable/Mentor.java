package dev.nithin_mathew.project.backend.Capstone.productService.inheritancerelations.singletable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="st_mentors")
@DiscriminatorValue(value = "3")
public class Mentor extends User {
    private double avg_rating;
}
