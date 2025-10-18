package com.clothes.damafashion.controller.dto;

import com.clothes.damafashion.entity.Product;
import com.clothes.damafashion.entity.Stock;
import com.clothes.damafashion.service.ProductService;

/**
 * The type Stock dto.
 */
public record StockCreationDto(Integer quantity, Long productId) {


  /**
   * From entity stock dto.
   *
   * @param productService the product service
   * @return the stock dto
   */
  public Stock toEntity(ProductService productService) {
    if (productService.findById(productId).isEmpty()) {
      throw new IllegalArgumentException("Product not found");
    }
    return new Stock(quantity, productService.findById(productId).get());
  }
}
