package com.clothes.damafashion.controller.dto;


import com.clothes.damafashion.entity.Category;
import com.clothes.damafashion.entity.Product;

import java.util.List;

/**
 * The type Category dto.
 */
public record CategoryDto(Long id, String name, List<Product> products) {


  /**
   * From entity category dto.
   *
   * @param category the category
   * @return the category dto
   */
  public static CategoryDto fromEntity(Category category) {

    return new CategoryDto(category.getId(), category.getName(), category.getProducts());
  }
}
