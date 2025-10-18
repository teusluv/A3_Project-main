package com.clothes.damafashion.service.exception;

/**
 * Exception for when a person is not found.
 */
public class UserNotFoundException extends RuntimeException {

  public UserNotFoundException() {
    super("Pessoa não encontrada!");
  }

}
