package com.clothes.damafashion.service;

import com.clothes.damafashion.entity.Category;
import com.clothes.damafashion.repository.CategoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * The type Category service.
 */
@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    /**
     * Instantiates a new Category service.
     *
     * @param categoryRepository the category repository
     */
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    /**
     * Find all list.
     *
     * @return the list
     */
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    /**
     * Find by id optional.
     *
     * @param id the id
     * @return the optional
     */
    public Optional<Category> findById(Long id) {
        return categoryRepository.findById(id);
    }

    /**
     * Save category.
     *
     * @param category the category
     * @return the category
     */
    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    /**
     * Update optional.
     *
     * @param id          the id
     * @param newCategory the new category
     * @return the optional
     */
    public Optional<Category> update(Long id, Category newCategory) {
        return categoryRepository.findById(id).map(category -> {
            category.setName(newCategory.getName());
            return categoryRepository.save(category);
        });
    }

    /**
     * Delete boolean.
     *
     * @param id the id
     * @return the boolean
     */
    @Transactional
    public boolean delete(Long id) {
        if (categoryRepository.existsById(id)) {
            categoryRepository.deleteById(id);
            return true;
        }
        return false;
    }
}