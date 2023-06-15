package com.mayank.productservice.service;

import com.mayank.productservice.dto.ProductRequest;
import com.mayank.productservice.dto.ProductResponse;
import com.mayank.productservice.model.Product;
import com.mayank.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {


  private final ProductRepository productRepository;

  public void createProduct(ProductRequest productRequest){
    Product product = Product.builder()
      .name(productRequest.getName())
      .description(productRequest.getDescription())
      .price(productRequest.getPrice())
      .build();

    productRepository.save(product);
    log.info("Product {} is added",product.getId());
  }


  public List<ProductResponse> getAllProducts() {
    List<Product> products = productRepository.findAll();
    products.stream().map(product -> mapToProductResponse())
  }

  private Object mapToProductResponse() {
  }
}
