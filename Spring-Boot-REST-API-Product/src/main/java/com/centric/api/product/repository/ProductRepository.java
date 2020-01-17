package com.centric.api.product.repository;

import com.centric.api.product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface Product repository.
 *
 * @author Zankhana Patel
 */
@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
}
