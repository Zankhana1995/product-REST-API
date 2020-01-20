package com.centric.api.product.controller;

import com.centric.api.product.SpringBootRestApiProductApplication;
import com.centric.api.product.model.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * The ProductControllerIntegrationTests class
 *
 * @author Zankhana Patel
 */

@SpringBootTest(classes = SpringBootRestApiProductApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductControllerIntegrationTests {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;
    private Object List;

    @Sql({ "classpath:schema.sql", "classpath:data.sql" })
    @Test
    public void testGetAllProducts()
    {

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Product>> response = restTemplate.exchange(
                "http://localhost:" + port + "/v1/products/searchProduct/findByCategory?category=apparel&pageNo=0&pageSize=10&sortBy=createdAt",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Product>>(){});
        List<Product> productList = response.getBody();

        assertThat(productList.size()).isEqualTo(3);
    }

    @Test
    public void testCreateProduct() {

        Product product = Product.builder().name("Red Shirt").description("Red hugo boss shirt").brand("Hugo Boss").category("apparel").build();

        ResponseEntity<String> responseEntity = this.restTemplate
                .postForEntity("http://localhost:" + port + "/v1/products/createProduct", product, String.class);

        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(HttpStatus.CREATED.value());
    }

}
