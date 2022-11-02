package com.products.eva.rest.service;

import com.products.eva.db.entity.Product;
import com.products.eva.db.repository.ProductRepo;
import com.products.eva.rest.dto.ProductDto;
import com.products.eva.rest.service.impl.ProductServiceImpl;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductServiceTest {
    static List<Product> products = new ArrayList<>();
    @Mock
    ProductRepo productRepo;
    @InjectMocks
    ProductServiceImpl productService;

    @BeforeAll
    public static void init() {
        products.add(new Product(
                1L,
                "Head Shoulders",
                "Шампунь против перхоти Head Shoulders Свежесть чайного дерева, 400 мл")
        );

        products.add(new Product(
                2L,
                "Syoss Keratin Shampoo",
                "Шампунь Syoss Keratin Shampoo для ломких волос, с голубым лотосом, 440 мл")
        );
    }

    @Test
    public void getByFilterPattern_returnsProductsThatAreNotStartWithE_ListProduct() {
        when(productRepo.findAll())
                .thenReturn(products);

        String patternByFilter = "^E.*$";
        List<ProductDto> productsDto = productService.getByFilterPattern(patternByFilter);

        assertNotNull(productsDto);
        assertFalse(productsDto.isEmpty());
        assertEquals(2, productsDto.size());

        long actualCountMatchesByPattern = productsDto
                .stream()
                .filter(product -> Pattern.matches(patternByFilter, product.getName()))
                .count();

        assertEquals(0, actualCountMatchesByPattern);
    }

    @Test
    public void getByFilterPattern_returnsProductsWithoutPatternForFilter_ListProduct() {
        when(productRepo.findAll())
                .thenReturn(products);

        List<ProductDto> productsDto = productService.getByFilterPattern("");

        assertNotNull(productsDto);
        assertFalse(productsDto.isEmpty());
        assertEquals(2, productsDto.size());
    }
}
