package com.centric.api.product.controller;

import com.centric.api.product.exception.ResourceNotFoundException;
import com.centric.api.product.model.Product;
import com.centric.api.product.service.ProductService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

/**
 * The ProductControllerTest class
 *
 * @author Zankhana Patel
 */

@ExtendWith(MockitoExtension.class)
public class ProductControllerTest {

    @InjectMocks
    ProductController productController;

    @Mock
    ProductService productService;

    @Test
    public void testCreateProduct()
    {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        Product product = Product.builder().name("Red Shirt").description("Red hugo boss shirt").brand("Hugo Boss").category("apparel").build();

        when(productService.saveProduct(any(Product.class))).thenReturn(product);

        ResponseEntity<Product> responseEntity = productController.createProduct(product);

        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(HttpStatus.CREATED.value());

    }

    @Test
    public void testGetAllProducts() throws ResourceNotFoundException {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        Product product1 = Product.builder().name("Red Shirt").description("Red hugo boss shirt").brand("Hugo Boss").category("apparel").build();
        Product product2 = Product.builder().name("Blue Shirt").description("Blue hugo boss shirt").brand("Hugo Boss").category("apparel").build();
        Product product3 = Product.builder().name("Yellow Shirt").description("Yellow hugo boss shirt").brand("Hugo Boss").category("apparel").build();

        List<Product> productList = Arrays.asList(product1,product2,product3);

        when(productService.getAllProducts(any(String.class),any(Integer.class),any(Integer.class),any(String.class))).thenReturn(productList);

        ResponseEntity<List<Product>> result = productController.getAllProducts("apparel",0,10,"createdAt");

        assertThat(result.getBody().size()).isEqualTo(3);
        assertThat(result.getBody().get(0).getName()).isEqualTo(product1.getName());

    }



}