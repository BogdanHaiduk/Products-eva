package com.products.eva.util;

import com.products.eva.db.entity.Product;
import com.products.eva.rest.dto.ProductDto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AdapterTest {
    @Test
    public void toProductDto_productAdaptToProductDto_returnProductDto() {
        Product product = new Product(
                72345L,
                "Head Shoulders",
                "Шампунь против перхоти Head Shoulders Свежесть чайного дерева, 400 мл");
        ProductDto productDto = Adapter.toProductDto(product);

        assertEquals(product.getId(), productDto.getId());
        assertEquals(product.getName(), productDto.getName());
        assertEquals(product.getDescription(), productDto.getDescription());
    }
}
