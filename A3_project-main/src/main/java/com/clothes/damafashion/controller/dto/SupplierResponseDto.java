package com.clothes.damafashion.controller.dto;

import com.clothes.damafashion.entity.Supplier;

import java.util.List;
import java.util.stream.Collectors;

public record SupplierResponseDto(
    Long id,
    String name,
    String contact,
    List<ProductSimpleDto> products
) {
    public static SupplierResponseDto fromEntity(Supplier supplier) {
        List<ProductSimpleDto> productDtos = supplier.getProducts() != null
            ? supplier.getProducts().stream()
                .map(product -> new ProductSimpleDto(
                    product.getId(),
                    product.getName(),
                    product.getPrice(),
                    product.getDescription()
                ))
                .collect(Collectors.toList())
            : List.of();

        return new SupplierResponseDto(
            supplier.getId(),
            supplier.getName(),
            supplier.getContact(),
            productDtos
        );
    }
    public record ProductSimpleDto(
        Long id,
        String name,
        Double price,
        String description
    ) {}
}