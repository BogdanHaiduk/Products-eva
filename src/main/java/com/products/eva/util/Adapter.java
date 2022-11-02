package com.products.eva.util;

import com.products.eva.db.entity.Product;
import com.products.eva.rest.dto.ProductDto;

public class Adapter {
    public static ProductDto toProductDto(Product product) {
        return new ProductDto(
                product.getId(),
                product.getName(),
                product.getDescription()
        );
    }
}
