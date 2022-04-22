package petcarehotel.webapplication.models;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import petcarehotel.webapplication.models.enumerations.Role;

/**
 * Class for the User entity.
 */
@Data
@Entity
@Table(name = "APPLICATION_USER")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User implements UserDetails {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "APPLICATION_USER_ID")
  private Long id;

  @Column(name = "USERNAME")
  private String username;

  @Column(name = "PASSWORD")
  private String password;

  @Column(name = "EMAIL")
  private String email;

  @Column(name = "FIRST_NAME")
  private String firstName;

  @Column(name = "LSAT_NAME")
  private String lastName;

  @Column(name = "NUMBER")
  private String number;

  @Enumerated(value = EnumType.STRING)
  @Column(name = "APPLICATION_ROLE")
  private Role role;

  @OneToMany(mappedBy = "owner", fetch = FetchType.EAGER)
  private List<Pet> pets;

  @Column(name = "IS_ACCOUNT_NON_EXPIRED")
  private boolean isAccountNonExpired = true;

  @Column(name = "IS_ACCOUNT_NON_LOCKED")
  private boolean isAccountNonLocked = true;

  @Column(name = "IS_CREDENTIALS_NON_EXPIRED")
  private boolean isCredentialsNonExpired = true;

  @Column(name = "IS_ENABLED")
  private boolean isEnabled = false;


  /**
   * Custom constructor.
   *
   * @param username  String
   * @param password  String
   * @param email     String
   * @param firstName String
   * @param lastName  String
   * @param number    String
   */
  public User(String username, String password, String email, String firstName, String lastName,
              String number) {
    this.username = username;
    this.password = password;
    this.email = email;
    this.firstName = firstName;
    this.lastName = lastName;
    this.number = number;
    this.role = Role.ROLE_USER;

  }

  public void addPet(Pet pet) {
    pets.add(pet);
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return Collections.singletonList(role);
  }

  @Override
  public boolean isAccountNonExpired() {
    return isAccountNonExpired;
  }

  @Override
  public boolean isAccountNonLocked() {
    return isAccountNonLocked;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return isCredentialsNonExpired;
  }

  @Override
  public boolean isEnabled() {
    return isEnabled;
  }
}
