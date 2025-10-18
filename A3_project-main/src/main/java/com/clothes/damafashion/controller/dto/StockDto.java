package com.clothes.damafashion.controller.dto;

import com.clothes.damafashion.entity.Product;
import com.clothes.damafashion.entity.Stock;

/**
 * The type Stock dto.
 */
public record StockDto(Long id, Integer quantity, Product product) {


  /**
   * From entity stock dto.
   *
   * @param stock the stock
   * @return the stock dto
   */
  public static StockDto fromEntity(Stock stock) {
    return new StockDto(stock.getId(), stock.getQuantity(), stock.getProduct());
  }
}
