package com.centric.api.product.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
/**
 * The Model class of Product
 *
 * @author Zankhana Patel
 */
@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name="products")
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false)
    private long id;

    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @Column(name = "desc", length = 100)
    private String description;

    @Column(name = "brand", length = 50)
    private String brand;
   // private List<String> tags;

    @Column(name = "category", length = 50)
    private String category;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", nullable = true)
    private Date createdAt;


}
