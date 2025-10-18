package com.clothes.damafashion.controller.dto;


import com.clothes.damafashion.entity.Category;
import com.clothes.damafashion.entity.Product;
import com.clothes.damafashion.entity.Supplier;

import java.time.LocalDate;


/**
 * The type Product dto.
 */
public record ProductDto(Long id, String name, Double price, String description,
                                 Category category, Supplier supplier) {


  /**
   * From entity product dto.
   *
   * @param product the product
   * @return the product dto
   */
  public static ProductDto fromEntity(Product product) {

    return new ProductDto(product.getId(), product.getName(), product.getPrice(), product.getDescription(),
        product.getCategory(), product.getSupplier());
  }
}
