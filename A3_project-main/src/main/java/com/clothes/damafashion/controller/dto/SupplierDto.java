package com.clothes.damafashion.controller.dto;

import com.clothes.damafashion.entity.Product;
import com.clothes.damafashion.entity.Supplier;

import java.util.List;

public record SupplierDto(Long id, String name, String contact, List<Product> products
                          ) {
  /**
   * To entity crop.
   *
   * @return the crop
   */
  public Supplier toEntity() {
    return new Supplier(name, contact);
  }
}
