package dev.nithin_mathew.project.backend.Capstone.productService.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GenericProductDto{
    private Long id;
    private String title;
    private Double price;
    private String description;
    private String category;
    private String image;
}
