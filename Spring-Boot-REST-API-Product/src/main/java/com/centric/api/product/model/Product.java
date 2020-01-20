package com.centric.api.product.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

/**
 * The Model class of Product
 *
 * @author Zankhana Patel
 */

@Getter
@Setter
@NoArgsConstructor
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
@AllArgsConstructor
@JsonPropertyOrder({
        "id",
        "name",
        "description",
        "brand",
        "tags",
        "category",
        "created_at"
})
@Entity
@Table(name="product")
public class Product extends AbstractBaseEntity implements Serializable {

    private static final long serialVersionUID = 6382812478527113490L;

    @Column(name = "name", length = 30, nullable = false)
    @NotEmpty(message = "Please provide a product name")
    @Size(max=30, message="Product name should not more than 30 characters")
    private String name;

    @Column(name = "desc", length = 100)
    @Size(max=100, message="Product description should not more than 100 characters")
    private String description;

    @Column(name = "brand", length = 30)
    @Size(max=30, message="Product brand should not more than 30 characters")
    private String brand;

    @ElementCollection
    @CollectionTable(name = "product_tags", joinColumns = @JoinColumn(name = "product_id"))
    @Column(name = "tags")
    private Set<String> tags = new HashSet<>();

    @Column(name = "category", length = 30)
    @Size(max=30, message="Product category should not more than 30 characters")
    private String category;

    @CreationTimestamp
    @Column(name = "created_at")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonProperty("created_at")
    private LocalDateTime createdAt;

}
