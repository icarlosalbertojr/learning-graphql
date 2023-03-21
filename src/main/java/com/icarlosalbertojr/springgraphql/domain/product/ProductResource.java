package com.icarlosalbertojr.springgraphql.domain.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
public class ProductResource {

    @Autowired
    private ProductRepository productRepository;

    @MutationMapping
    public ProductEntity addProduct(@Argument ProductInput product) {
        return productRepository.save(new ProductEntity(product.name, product.price, product.categoryId));
    }

    @QueryMapping
    public Optional<ProductEntity> productById(@Argument UUID productId) {
        return productRepository.findById(productId);
    }

    @QueryMapping
    public List<ProductEntity> productFindAll() {
        return productRepository.findAll();
    }

    record ProductInput(String name, BigDecimal price, UUID categoryId) {}

}
