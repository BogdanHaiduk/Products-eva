package com.products.eva;

import com.products.eva.rest.dto.ProductDto;
import com.products.eva.util.TestUtil;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;

import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

@FieldDefaults(level = AccessLevel.PRIVATE)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class IntegrationTest {
    @Value("${server.test.host}")
    String testHost;
    final TestRestTemplate testRestTemplate = new TestRestTemplate();
    final HttpHeaders httpHeaders = new HttpHeaders();

    @Test
    public void integrationTest_getAllEmployee_byEndpoint() {
        String patternByFilter = "^E.*$";
        String url = TestUtil.getURL(testHost, "shop/product", Collections.singletonMap("nameFilter", patternByFilter));

        ResponseEntity<List<ProductDto>> response =
                testRestTemplate.exchange(
                        url,
                        HttpMethod.GET,
                        new HttpEntity<>(httpHeaders),
                        new ParameterizedTypeReference<List<ProductDto>>() {
                        });

        assertEquals(HttpStatus.OK, response.getStatusCode());

        List<ProductDto> productsDto = response.getBody();

        assertNotNull(productsDto);
        assertFalse(productsDto.isEmpty());
        assertEquals(2, productsDto.size());

        long actualCountMatchesByPattern = productsDto
                .stream()
                .filter(product -> Pattern.matches(patternByFilter, product.getName()))
                .count();

        assertEquals(0, actualCountMatchesByPattern);
    }
}
