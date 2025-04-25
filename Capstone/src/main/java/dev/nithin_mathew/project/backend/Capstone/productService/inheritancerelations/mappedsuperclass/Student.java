package dev.nithin_mathew.project.backend.Capstone.productService.inheritancerelations.mappedsuperclass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "ms_students")
public class Student extends User{
    private double psp;

}
