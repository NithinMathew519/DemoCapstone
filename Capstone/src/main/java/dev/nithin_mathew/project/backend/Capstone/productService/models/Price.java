package dev.nithin_mathew.project.backend.Capstone.productService.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Price extends BaseModel {
    private String currency ;
    private Double Value;
}
