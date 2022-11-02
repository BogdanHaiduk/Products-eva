package com.products.eva.rest.controller;

import com.products.eva.rest.dto.ProductDto;
import com.products.eva.rest.service.ProductService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/shop")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ControllerRest {
    final ProductService productService;

    public ControllerRest(@Qualifier("productServiceImpl") ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/product")
    public List<ProductDto> product(@RequestParam(name = "nameFilter") String nameFilter) {
        return productService.getByFilterPattern(nameFilter);
    }
}
