package dev.nithin_mathew.project.backend.Capstone.productService.services;

import dev.nithin_mathew.project.backend.Capstone.productService.Exceptions.ProductNotFoundException;
import dev.nithin_mathew.project.backend.Capstone.productService.ThirdPartyClients.FakeStoreClient.FakeStoreClientAdapter;
import dev.nithin_mathew.project.backend.Capstone.productService.dtos.FakeStoreProductDto;
import dev.nithin_mathew.project.backend.Capstone.productService.dtos.GenericProductDto;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class FakeStoreProductService implements ProductService {
    private final FakeStoreClientAdapter fakeStoreClientAdapter;
    FakeStoreProductService(FakeStoreClientAdapter fakeStoreClientAdapter) {
        this.fakeStoreClientAdapter = fakeStoreClientAdapter;
    }
    private final String specificProductUrl="https://fakestoreapi.com/products/{id}";
    private final String getAllProductsUrl="https://fakestoreapi.com/products";
    private static GenericProductDto convertToGenericProductDto(FakeStoreProductDto fakeStoreProductDto){
        GenericProductDto genericProductDto = new GenericProductDto();
        genericProductDto.setId(fakeStoreProductDto.getId());
        genericProductDto.setTitle(fakeStoreProductDto.getTitle());
        genericProductDto.setDescription(fakeStoreProductDto.getDescription());
        genericProductDto.setPrice(fakeStoreProductDto.getPrice());
        genericProductDto.setCategory(fakeStoreProductDto.getCategory());
        genericProductDto.setImage(fakeStoreProductDto.getImage());
        return genericProductDto;
    }
    @Override
    public GenericProductDto getProductsById(Long id) throws ProductNotFoundException {
        return convertToGenericProductDto(fakeStoreClientAdapter.getProductsById(id));
    }

    @Override
    public List<GenericProductDto> getAllProducts() {
        List<FakeStoreProductDto> fakeStoreProductDtos = fakeStoreClientAdapter.getAllProducts();
        List<GenericProductDto> genericProductDtos = new ArrayList<>();
        for (FakeStoreProductDto fakeStoreProductDto : fakeStoreProductDtos) {
            genericProductDtos.add(convertToGenericProductDto(fakeStoreProductDto));
        }
        return genericProductDtos;
    }

    @Override
    public GenericProductDto deleteProductsById(Long id) {
        return convertToGenericProductDto(fakeStoreClientAdapter.deleteProductsById(id));
    }

    @Override
    public GenericProductDto updateProductsById(Long id, GenericProductDto genericProductDto) {
        return convertToGenericProductDto(fakeStoreClientAdapter.updateProductsById(id, genericProductDto));
    }


    @PostMapping
    public GenericProductDto createProduct(GenericProductDto genericProductDto) {
        return convertToGenericProductDto(fakeStoreClientAdapter.createProduct(genericProductDto));
    }
}