package com.clothes.damafashion.entity;


import com.clothes.damafashion.security.Role;
import jakarta.persistence.*;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * Class representing a user.
 */
@Setter
@Entity
@Table(name = "users")
public class User implements UserDetails {

    /**
     * -- GETTER --
     *  Gets id.
     * <p>
     *
     * -- SETTER --
     *  Sets id.
     *
     */
    @Getter
    @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

    /**
     * -- SETTER --
     *  Sets username.
     *
     */
    @Column(unique = true)
  private String username;

    /**
     * -- SETTER --
     *  Sets password.
     *
     */
    private String password;

    /**
     * -- GETTER --
     *  Gets role.
     * <p>
     *
     * -- SETTER --
     *  Sets role.
     *
     */
    @Getter
    @Enumerated(EnumType.STRING)
    private Role role;

  /**
   * Instantiates a new User.
   */
  public User() {
  }

  /**
   * Instantiates a new User.
   *
   * @param username the username
   * @param password the password
   * @param role     the role
   */
  public User(String username, String password, Role role) {
    this.username = username;
    this.password = password;
    this.role = role;
  }


    @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }

    @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return List.of(new SimpleGrantedAuthority(role.name()));
  }

  @Override
  public String getPassword() {
    return password;
  }


  @Override
  public String getUsername() {
    return username;
  }

    @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    User user = (User) o;
    return Objects.equals(id, user.id) && Objects.equals(username,
        user.username) && Objects.equals(password, user.password)
        && Objects.equals(role, user.role);
  }
}

