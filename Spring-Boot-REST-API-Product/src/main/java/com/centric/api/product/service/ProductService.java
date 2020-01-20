package com.centric.api.product.service;

import com.centric.api.product.exception.ResourceNotFoundException;
import com.centric.api.product.model.Product;
import com.centric.api.product.model.ProductSpecification;
import com.centric.api.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The ProductService Class
 *
 * @author Zankhana Patel
 */

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<Product> getAllProducts(String category, Integer pageNo, Integer pageSize, String sortBy) throws ResourceNotFoundException {

        Product product = new Product();
        product.setCategory(category);
        Specification<Product> specification = new ProductSpecification(product);
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy).descending());

        Page<Product> pagedResult = productRepository.findAll(specification, paging);

        if (pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            throw new ResourceNotFoundException("Products not found");
        }
    }

    public Product saveProduct(Product product) {

        return productRepository.save(product);
    }

}
