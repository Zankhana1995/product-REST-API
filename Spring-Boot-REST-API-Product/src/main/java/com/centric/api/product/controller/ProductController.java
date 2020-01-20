package com.centric.api.product.controller;

import com.centric.api.product.exception.ResourceNotFoundException;
import com.centric.api.product.model.Product;
import com.centric.api.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * The Rest endpoint of the Product application
 *
 * @author Zankhana Patel
 */
@RestController
@RequestMapping("/v1/products")
public class ProductController {

    @Autowired
    ProductService productService;

    /**
     * Get all product list.
     *
     * @return the list
     */
    @GetMapping("/searchProduct/findByCategory")
    public ResponseEntity<List<Product>> getAllProducts(
            @RequestParam("category") String category,
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "createdAt") String sortBy) throws ResourceNotFoundException {

        return ResponseEntity.ok().body(productService.getAllProducts(category, pageNo, pageSize, sortBy));
    }

    /**
     * Create Product.
     *
     * @param product the product
     * @return the user
     */
    @PostMapping("/createProduct")
    public ResponseEntity<Product> createProduct(@Valid @RequestBody Product product) {
        HttpHeaders httpHeaders = new HttpHeaders();
        return new ResponseEntity<Product>(productService.saveProduct(product), httpHeaders, HttpStatus.CREATED);
    }


}
