package com.centric.api.product.controller;

import com.centric.api.product.model.Product;
import com.centric.api.product.repository.ProductRepository;
import com.centric.api.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * The Rest endpoint of the Product application
 *
 * @author Zankhana Patel
 */
@RestController
@RequestMapping("/v1")
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductService productService;


    /**
     * Get all product list.
     *
     * @return the list
     */
    @GetMapping("/products/search/findByCategory")
    public List<Product> getAllProducts(

            @RequestParam("category") String category,
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "createdAt") String sortBy

    ) {

        return productService.getAllProducts(category,pageNo,pageSize,sortBy);


    }

    /**
     * Create Product.
     *
     * @param product the product
     * @return the user
     */
    @PostMapping("/product")
    public Product createProduct(@Valid @RequestBody Product product) {
        return productRepository.save(product);
    }


}
