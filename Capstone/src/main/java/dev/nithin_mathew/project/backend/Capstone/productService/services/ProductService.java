package dev.nithin_mathew.project.backend.Capstone.productService.services;

import dev.nithin_mathew.project.backend.Capstone.productService.dtos.GenericProductDto;

import java.util.List;

public interface ProductService{
    GenericProductDto getProductsById(Long id);
    List<GenericProductDto> getAllProducts();
    void deleteProductsById();
    void updateProductsById();
    GenericProductDto createProduct(GenericProductDto genericProductDto);
}