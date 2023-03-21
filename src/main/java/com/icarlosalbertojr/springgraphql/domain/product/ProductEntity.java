package com.icarlosalbertojr.springgraphql.domain.product;

import com.icarlosalbertojr.springgraphql.domain.category.CategoryEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name="category_id", insertable = false, updatable = false)
    private CategoryEntity category;

    @Column(name = "category_id")
    private UUID categoryId;

    public ProductEntity(String name, BigDecimal price, UUID categoryId) {
        this.name = name;
        this.price = price;
        this.categoryId = categoryId;
    }
}
