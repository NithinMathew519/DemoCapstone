package dev.nithin_mathew.project.backend.Capstone.productService.services;

import dev.nithin_mathew.project.backend.Capstone.productService.Exceptions.ProductNotFoundException;
import dev.nithin_mathew.project.backend.Capstone.productService.dtos.FakeStoreProductDto;
import dev.nithin_mathew.project.backend.Capstone.productService.dtos.GenericProductDto;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class FakeStoreProductService implements ProductService {
    private final RestTemplateBuilder restTemplateBuilder;
    FakeStoreProductService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
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
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> responseEntity = restTemplate.getForEntity(specificProductUrl, FakeStoreProductDto.class, id);
        FakeStoreProductDto fakeStoreProductDto = responseEntity.getBody();
        if(fakeStoreProductDto == null){
            throw new ProductNotFoundException("Product with id "+id+" Doesn't Exist");
        }

//        Convert FakeStoreProductDto to genericProductDto before returning
        return convertToGenericProductDto(responseEntity.getBody());
    }

    @Override
    public List<GenericProductDto> getAllProducts() {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto[]> responseEntity = restTemplate.getForEntity(getAllProductsUrl, FakeStoreProductDto[].class);

        List <GenericProductDto> result = new ArrayList<>();
        for (FakeStoreProductDto fakeStoreProductDtos : Objects.requireNonNull(responseEntity.getBody())) {
            result.add(convertToGenericProductDto(fakeStoreProductDtos));
        }
        return result;
    }

    @Override
    public GenericProductDto deleteProductsById(Long id) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        RequestCallback requestCallback = restTemplate.acceptHeaderRequestCallback(FakeStoreProductDto.class);
        ResponseExtractor<ResponseEntity<FakeStoreProductDto>> responseExtractor = restTemplate.responseEntityExtractor(FakeStoreProductDto.class);
        ResponseEntity<FakeStoreProductDto> responseEntity=restTemplate.execute(specificProductUrl, HttpMethod.DELETE, requestCallback, responseExtractor, id);
        return convertToGenericProductDto(responseEntity.getBody());
    }

    @Override
    public GenericProductDto updateProductsById(Long id, GenericProductDto genericProductDto) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> responseEntity = restTemplate.exchange(specificProductUrl,HttpMethod.PUT,new org.springframework.http.HttpEntity<>(genericProductDto),FakeStoreProductDto.class,id);
        return convertToGenericProductDto(responseEntity.getBody());

    }


    @PostMapping
    public GenericProductDto createProduct(GenericProductDto genericProductDto) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> responseEntity=restTemplate.postForEntity(getAllProductsUrl,genericProductDto,FakeStoreProductDto.class);
        return convertToGenericProductDto(responseEntity.getBody());
    }
}