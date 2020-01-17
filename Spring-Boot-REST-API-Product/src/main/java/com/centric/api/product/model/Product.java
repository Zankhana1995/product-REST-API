package com.centric.api.product.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.Entity;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Product {
    private String name;
    private String description;
    private String brand;
    private List<String> tags;
    private String category;
    
}
