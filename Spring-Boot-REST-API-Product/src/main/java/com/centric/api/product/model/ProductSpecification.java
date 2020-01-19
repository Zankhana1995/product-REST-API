package com.centric.api.product.model;

import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class ProductSpecification implements Specification<Product> {


    private Product filter;

    public ProductSpecification(Product filter) {
        super();
        this.filter = filter;
    }

    @Override
    public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {

        Predicate predicate = criteriaBuilder.disjunction();

        if (filter.getCategory() != null) {
            predicate.getExpressions()
                    .add(criteriaBuilder.equal(root.get("category"), filter.getCategory()));
        }


        return predicate;
    }
}
