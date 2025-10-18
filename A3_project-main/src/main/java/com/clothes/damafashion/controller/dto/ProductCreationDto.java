package com.clothes.damafashion.controller.dto;

import com.clothes.damafashion.entity.Category;
import com.clothes.damafashion.entity.Product;
import com.clothes.damafashion.entity.Supplier;
import com.clothes.damafashion.service.CategoryService;
import com.clothes.damafashion.service.SupplierService;

import java.util.Optional;

/**
 * The type Product creation dto.
 */
public record ProductCreationDto(String name, Double price, String description,
                                 Long categoryId, Long supplierId) {

    /**
     * To entity product.
     *
     * @param categoryService the category service
     * @param supplierService the supplier service
     * @return the product
     */
    public Product toEntity(CategoryService categoryService, SupplierService supplierService) {
        Optional<Category> category = categoryService.findById(categoryId);
        Optional<Supplier> supplier = supplierService.findById(supplierId);
        if (category.isEmpty() || supplier.isEmpty()) {
            throw new IllegalArgumentException("Category or Supplier not found");
        }
        return new Product(name, price, description, category.get(), supplier.get());
    }

}
