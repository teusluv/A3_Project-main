package com.clothes.damafashion.controller.dto;

import com.clothes.damafashion.entity.Category;
import com.clothes.damafashion.entity.Product;

import java.util.List;
import java.util.stream.Collectors;

public record CategoryResponseDto(
    Long id,
    String name,
    List<ProductSimpleDto> products
) {
    public static CategoryResponseDto fromEntity(Category category) {
        List<ProductSimpleDto> productDtos = category.getProducts() != null
            ? category.getProducts().stream()
                .map(product -> new ProductSimpleDto(
                    product.getId(),
                    product.getName(),
                    product.getPrice(),
                    product.getDescription()
                ))
                .collect(Collectors.toList())
            : List.of();

        return new CategoryResponseDto(
            category.getId(),
            category.getName(),
            productDtos
        );
    }

    // DTO simplificado para produtos dentro de categoria
    public record ProductSimpleDto(
        Long id,
        String name,
        Double price,
        String description
    ) {}
}

