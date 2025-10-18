package com.clothes.damafashion.controller.dto;

import com.clothes.damafashion.entity.Stock;

public record StockResponseDto(
    Long id,
    Integer quantity,
    Long productId,
    String productName
) {
    public static StockResponseDto fromEntity(Stock stock) {
        return new StockResponseDto(
            stock.getId(),
            stock.getQuantity(),
            stock.getProduct().getId(),
            stock.getProduct().getName()
        );
    }
}
