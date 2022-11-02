package com.products.eva.rest.service.impl;

import com.products.eva.db.repository.ProductRepo;
import com.products.eva.rest.dto.ProductDto;
import com.products.eva.rest.service.ProductService;
import com.products.eva.util.Adapter;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductServiceImpl implements ProductService {
    final ProductRepo productRepo;

    @Autowired
    public ProductServiceImpl(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    @Override
    public List<ProductDto> getByFilterPattern(String pattern) {
        log.debug("Started searching products with pattern - {}", pattern);

        return productRepo.findAll()
                .stream()
                .filter(product -> !Pattern.matches(pattern, product.getName()))
                .map(Adapter::toProductDto)
                .collect(Collectors.toList());
    }
}
