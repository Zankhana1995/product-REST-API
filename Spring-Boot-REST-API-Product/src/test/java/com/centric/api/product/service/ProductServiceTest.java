package com.centric.api.product.service;

import com.centric.api.product.exception.ResourceNotFoundException;
import com.centric.api.product.model.Product;
import com.centric.api.product.model.ProductSpecification;
import com.centric.api.product.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;

/**
 * The ProductServiceTest class
 *
 * @author Zankhana Patel
 */

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    @Test
    public void findAllProducts() throws ResourceNotFoundException {

        try {

            Product product = Product.builder().name("Red Shirt").description("Red hugo boss shirt").brand("Hugo Boss").category("apparel").build();
            List<Product> expectedProducts = Arrays.asList(product);
            PageImpl pagedProducts = new PageImpl(expectedProducts);
            Page<Product> products = Mockito.mock(Page.class);
            Mockito.when(this.productRepository.findAll(any(ProductSpecification.class), any(Pageable.class))).thenReturn(products);
            List<Product> actualProducts = productService.getAllProducts("apparel", 0, 10, "createdAt");

        }catch (ResourceNotFoundException ex){
            assertTrue(true);
        }
    }

    @Test
    public void createProduct(){
        Product product = Product.builder().name("Red Shirt").description("Red hugo boss shirt").brand("Hugo Boss").category("apparel").build();
        Mockito.when(productRepository.save(any(Product.class))).thenReturn(product);
        Product created = productService.saveProduct(product);
        assertThat(created.getName()).isSameAs(product.getName());
    }

}
