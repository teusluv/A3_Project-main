package com.clothes.damafashion.controller.dto;


import com.clothes.damafashion.entity.Category;
import com.clothes.damafashion.entity.Product;

import java.util.List;

/**
 * The type Category creation dto.
 */
public record CategoryCreationDto(String name, List<Product> products ) {


  /**
   * To entity category.
   *
   * @return the category
   */
  public Category toEntity() {
    return new Category(name, products);
  }
}
