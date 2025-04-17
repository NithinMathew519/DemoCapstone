package dev.nithin_mathew.project.backend.Capstone.productService.ThirdPartyClients.FakeStoreClient;

import dev.nithin_mathew.project.backend.Capstone.productService.Exceptions.ProductNotFoundException;
import dev.nithin_mathew.project.backend.Capstone.productService.dtos.FakeStoreProductDto;
import dev.nithin_mathew.project.backend.Capstone.productService.dtos.GenericProductDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class FakeStoreClientAdapter {
    private String specificProductUrl;
    private String getAllProductsUrl;
    private final RestTemplateBuilder restTemplateBuilder;
    FakeStoreClientAdapter(RestTemplateBuilder restTemplateBuilder,@Value("${fakestore.api.url}") String fakeStoreUrl,@Value("${fakestore.api.paths.products}")String productsPath) {
        this.restTemplateBuilder = restTemplateBuilder;
        this.getAllProductsUrl = fakeStoreUrl+productsPath;
        this.specificProductUrl = fakeStoreUrl+productsPath+"/{id}";
    }
//    private final String specificProductUrl="https://fakestoreapi.com/products/{id}";
//    private final String getAllProductsUrl="https://fakestoreapi.com/products";
    public FakeStoreProductDto getProductsById(Long id) throws ProductNotFoundException {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> responseEntity = restTemplate.getForEntity(specificProductUrl, FakeStoreProductDto.class, id);
        FakeStoreProductDto fakeStoreProductDto = responseEntity.getBody();
        if(fakeStoreProductDto == null){
            throw new ProductNotFoundException("Product with id "+id+" Doesn't Exist");
        }

        return fakeStoreProductDto;
    }

    public List<FakeStoreProductDto> getAllProducts() {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto[]> responseEntity = restTemplate.getForEntity(getAllProductsUrl, FakeStoreProductDto[].class);
        return List.of(responseEntity.getBody());
    }

    public FakeStoreProductDto deleteProductsById(Long id) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        RequestCallback requestCallback = restTemplate.acceptHeaderRequestCallback(FakeStoreProductDto.class);
        ResponseExtractor<ResponseEntity<FakeStoreProductDto>> responseExtractor = restTemplate.responseEntityExtractor(FakeStoreProductDto.class);
        ResponseEntity<FakeStoreProductDto> responseEntity=restTemplate.execute(specificProductUrl, HttpMethod.DELETE, requestCallback, responseExtractor, id);
        return responseEntity.getBody();
    }

    public FakeStoreProductDto updateProductsById(Long id, GenericProductDto genericProductDto) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> responseEntity = restTemplate.exchange(specificProductUrl,HttpMethod.PUT,new org.springframework.http.HttpEntity<>(genericProductDto),FakeStoreProductDto.class,id);
        return responseEntity.getBody();

    }


    @PostMapping
    public FakeStoreProductDto createProduct(GenericProductDto genericProductDto) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> responseEntity=restTemplate.postForEntity(getAllProductsUrl,genericProductDto,FakeStoreProductDto.class);
        return responseEntity.getBody();
    }
}
