package com.clothes.damafashion.controller.dto;


import com.clothes.damafashion.entity.User;
import com.clothes.damafashion.security.Role;

/**
 * The type User creation dto.
 */
public record UserCreationDto(String username, String password, Role role) {

  /**
   * To entity user.
   *
   * @return the user
   */
  public User toEntity() {
    return new User(username, password, role);
  }
}
