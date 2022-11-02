package com.products.eva.rest.service;

import com.products.eva.exception.NotImplementedException;
import com.products.eva.rest.dto.ProductDto;

import java.util.List;

public interface ProductService {

    /**
     * Getting a selected array of products by pattern
     *
     * @return The ProductDto this is a representation of the essence of the product.
     * @throws NotImplementedException - throwing an exception of this type will mean that the method is not implemented.
     */
    default List<ProductDto> getByFilterPattern(String pattern) {
        throw new NotImplementedException("Ficha not implemented...");
    }
}
