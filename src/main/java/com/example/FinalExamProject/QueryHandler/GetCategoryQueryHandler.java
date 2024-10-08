package com.example.FinalExamProject.QueryHandler;

import com.example.FinalExamProject.Category.Category;
import com.example.FinalExamProject.Category.CategoryRepository;
import com.example.FinalExamProject.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GetCategoryQueryHandler implements Query<Void,List<String>> {
    private final Logger logger = LoggerFactory.getLogger(GetCategoryQueryHandler.class);

    private final CategoryRepository categoryRepository;

    public GetCategoryQueryHandler(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public ResponseEntity<List<String>> executes(Void input) {
        logger.info("Executing {} GetCategoryQueryHandler",  getClass().getSimpleName());
        List<String> categoryValues = categoryRepository
                .findAll()
                .stream()
                .map(Category::getValue)
                .collect(Collectors.toList());

        return ResponseEntity.ok(categoryValues);
    }
}
