package dev.nithin_mathew.project.backend.Capstone.productService.controllers;

import dev.nithin_mathew.project.backend.Capstone.productService.Exceptions.ProductNotFoundException;
import dev.nithin_mathew.project.backend.Capstone.productService.dtos.GenericProductDto;
import dev.nithin_mathew.project.backend.Capstone.productService.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;
    ProductController(@Qualifier("fakeStoreProductService") ProductService productService){
        this.productService=productService;
    }
    @GetMapping("/{id}")
    public GenericProductDto getProductsById(@PathVariable("id")Long id) throws ProductNotFoundException {
        return productService.getProductsById(id);
    }
    @GetMapping
    public List<GenericProductDto> getAllProducts(){
        return productService.getAllProducts();
    }
    @DeleteMapping("{id}")
    public GenericProductDto deleteProductsById(@PathVariable("id")Long id){
        return productService.deleteProductsById(id);
    }
    @PutMapping("/{id}")
    public GenericProductDto updateProductsById(@PathVariable("id") Long id, @RequestBody GenericProductDto genericProductDto) {
        return productService.updateProductsById(id, genericProductDto);
    }
    @PostMapping
    public GenericProductDto createProduct(@RequestBody GenericProductDto genericProductDto) {
        return productService.createProduct(genericProductDto);
    }
//    @ExceptionHandler(ProductNotFoundException.class)
//    private ResponseEntity<ExceptionDto> handleProductNotFoundException(ProductNotFoundException productNotFoundException) {
//        ExceptionDto exceptionDto = new ExceptionDto();
//        exceptionDto.setMessage(productNotFoundException.getMessage());
//        exceptionDto.setStatus(HttpStatus.NOT_FOUND);
//        ResponseEntity<ExceptionDto> responseEntity = new ResponseEntity<>(exceptionDto, HttpStatus.NOT_FOUND);
//        return responseEntity;
//    }
}
