package com.clothes.damafashion.controller.dto;

import com.clothes.damafashion.entity.Product;

public record ProductResponseDto(
    Long id,
    String name,
    Double price,
    String description,
    Long categoryId,
    String categoryName,
    Long supplierId,
    String supplierName
) {
    public static ProductResponseDto fromEntity(Product product) {
        return new ProductResponseDto(
            product.getId(),
            product.getName(),
            product.getPrice(),
            product.getDescription(),
            product.getCategory().getId(),
            product.getCategory().getName(),
            product.getSupplier().getId(),
            product.getSupplier().getName()
        );
    }
}
