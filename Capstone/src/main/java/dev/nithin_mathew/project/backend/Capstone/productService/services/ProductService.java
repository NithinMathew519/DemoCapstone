package dev.nithin_mathew.project.backend.Capstone.productService.services;

import dev.nithin_mathew.project.backend.Capstone.productService.Exceptions.ProductNotFoundException;
import dev.nithin_mathew.project.backend.Capstone.productService.dtos.GenericProductDto;

import java.util.List;

public interface ProductService{
    GenericProductDto getProductsById(Long id) throws ProductNotFoundException;
    List<GenericProductDto> getAllProducts();
    GenericProductDto deleteProductsById(Long id);
    GenericProductDto updateProductsById(Long id, GenericProductDto genericProductDto);
    GenericProductDto createProduct(GenericProductDto genericProductDto);
}