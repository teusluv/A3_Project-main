package com.clothes.damafashion.security;

import lombok.Getter;

/**
 * Enum representing a Role.
 */
@Getter
public enum Role {
  ADMIN("ADMIN"),
  USER("USER");

  private final String name;

  Role(String name) {
    this.name = name;
  }
}