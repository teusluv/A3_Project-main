package com.clothes.damafashion.controller;

import com.clothes.damafashion.controller.dto.UserCreationDto;
import com.clothes.damafashion.controller.dto.UserDto;
import com.clothes.damafashion.entity.User;
import com.clothes.damafashion.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

/**
 * The type User controller.
 */
@RestController
@RequestMapping("/api/users")
public class UserController {

  private final UserService userService;

  /**
   * Instantiates a new User controller.
   *
   * @param userService the user service
   */
  @Autowired
  public UserController(UserService userService) {
    this.userService = userService;
  }


  /**
   * Create user dto.
   *
   * @param user the user
   * @return the user dto
   */
  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public UserDto createUser(@RequestBody UserCreationDto user) {
    return UserDto.fromEntity(userService.create(user.toEntity()));
  }

  @GetMapping("/me")
  public ResponseEntity<UserDto> getCurrentUser(Authentication authentication) {
    if (authentication == null || !authentication.isAuthenticated()) {
      return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
    UserDetails userDetails = (UserDetails) authentication.getPrincipal();
    User user = userService.getuserByUsername(userDetails.getUsername());
    return ResponseEntity.ok(new UserDto(user.getId(), user.getUsername(), user.getRole()));
  }

}
