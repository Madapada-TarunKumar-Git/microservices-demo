package com.example.productservice.service;

import com.example.productservice.dto.ProductRequest;
import com.example.productservice.dto.ProductResponse;
import com.example.productservice.mapper.ProductMapper;
import com.example.productservice.repo.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public ProductResponse createProduct(ProductRequest productRequest) {
        return null;
    }

    @Override
    public ProductResponse getProductById(Long id) {
        return null;
    }

    @Override
    public List<ProductResponse> getAllProducts() {
        return List.of();
    }
}
