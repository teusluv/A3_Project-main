package com.clothes.damafashion.controller.dto;


import com.clothes.damafashion.entity.User;
import com.clothes.damafashion.security.Role;

/**
 * The type User dto.
 */
public record UserDto(Long id, String username, Role role) {

  /**
   * From entity user dto.
   *
   * @param user the user
   * @return the user dto
   */
  public static UserDto fromEntity(User user) {
    return new UserDto(user.getId(), user.getUsername(), user.getRole());
  }
}
