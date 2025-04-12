package dev.nithin_mathew.project.backend.Capstone.productService.dtos;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
@Getter
@Setter
public class ExceptionDto {
    private HttpStatus status;
    private String message;
}
