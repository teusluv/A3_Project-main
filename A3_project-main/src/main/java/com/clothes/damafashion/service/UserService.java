package com.clothes.damafashion.service;

import java.util.Optional;

import com.clothes.damafashion.entity.User;
import com.clothes.damafashion.repository.UserRepository;
import com.clothes.damafashion.service.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Service layer class for handling users' business logic.
 */
@Service
@Primary
public class UserService implements UserDetailsService {

  private final UserRepository userRepository;

  /**
   * Instantiates a new user service.
   *
   * @param userRepository the user repository
   */
  @Autowired
  public UserService(
      UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  /**
   * Returns a user for a given ID.
   *
   * @param id the id
   * @return the user by id
   */
  public User getuserById(Long id) {
    Optional<User> user = userRepository.findById(id);

    if (user.isEmpty()) {
      throw new UserNotFoundException();
    }

    return user.get();
  }

  /**
   * Returns a user for a given username.
   *
   * @param username the username
   * @return the user by username
   */
  public User getuserByUsername(String username) {
    Optional<User> user = userRepository.findByUsername(username);

    if (user.isEmpty()) {
      throw new UserNotFoundException();
    }

    return user.get();
  }

  /**
   * Creates a new user.
   *
   * @param user the user
   * @return the user
   */
  public User create(User user) {
    String hashedPassword = new BCryptPasswordEncoder().encode(user.getPassword());
    user.setPassword(hashedPassword);
    return userRepository.save(user);
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    return userRepository.findByUsername(username)
        .orElseThrow(() -> new UsernameNotFoundException(username));
  }
}
