package com.icarlosalbertojr.springgraphql.modules.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.Optional;
import java.util.UUID;

@Controller
public class CategoryResource {

    @Autowired
    private CategoryRepository categoryRepository;

    @MutationMapping
    public CategoryEntity addCategory(@Argument CategoryInput category) {
        return categoryRepository.save(new CategoryEntity(category.name));
    }

    @QueryMapping
    public Optional<CategoryEntity> categoryById(@Argument UUID id) {
        return categoryRepository.findById(id);
    }

    record CategoryInput(String name) {}
}
