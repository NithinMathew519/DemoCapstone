package dev.nithin_mathew.project.backend.Capstone.productService.controllers;

import dev.nithin_mathew.project.backend.Capstone.productService.Exceptions.ProductNotFoundException;
import dev.nithin_mathew.project.backend.Capstone.productService.dtos.ExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProductControllerAdvice {
    @ExceptionHandler(ProductNotFoundException.class)
//    Method 1:
//    @ResponseStatus(HttpStatus.NOT_FOUND)
//    @ResponseBody
//    private ExceptionDto handleProductNotFoundException(ProductNotFoundException productNotFoundException) {
//        ExceptionDto exceptionDto = new ExceptionDto();
//        exceptionDto.setMessage(productNotFoundException.getMessage());
//        exceptionDto.setStatus(HttpStatus.NOT_FOUND);
//        return exceptionDto;

//    Method 2:
    private ResponseEntity<ExceptionDto> handleProductNotFoundException(ProductNotFoundException productNotFoundException) {
        ExceptionDto exceptionDto = new ExceptionDto();
        exceptionDto.setMessage(productNotFoundException.getMessage());
        exceptionDto.setStatus(HttpStatus.NOT_FOUND);
        ResponseEntity<ExceptionDto> responseEntity = new ResponseEntity<>(exceptionDto, HttpStatus.NOT_FOUND);
        return responseEntity;
    }
}
