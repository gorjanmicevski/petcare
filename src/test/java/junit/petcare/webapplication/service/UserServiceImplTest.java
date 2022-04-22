package junit.petcare.webapplication.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import petcarehotel.webapplication.config.token.ConfirmationTokenService;
import petcarehotel.webapplication.models.User;
import petcarehotel.webapplication.repository.UserRepository;
import petcarehotel.webapplication.service.impl.UserServiceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static support.TestObjectGenerator.generateUser;

public class UserServiceImplTest {
  private UserServiceImpl instanceUnderTest;
  private UserRepository userRepository;

  @BeforeEach
  void init() {
    userRepository = mock(UserRepository.class);
    ConfirmationTokenService confirmationTokenService = mock(ConfirmationTokenService.class);
    PasswordEncoder passwordEncoder = mock(PasswordEncoder.class);
    instanceUnderTest = new UserServiceImpl(userRepository, passwordEncoder, confirmationTokenService);
  }

  @Test
  void testAddUser() {
    final var user = generateUser();

    when(userRepository.save(any(User.class))).thenReturn(user);

    this.instanceUnderTest.addUser(user);

    verify(userRepository).save(user);
  }

  @Test
  void testRegisterUser() {
    final var user = generateUser();

    when(userRepository.save(any(User.class))).thenReturn(user);

    this.instanceUnderTest.register(user);

    verify(userRepository).save(user);
  }

  @Test
  void testEnableUser() {
    final var user = mock(User.class);

    final var result = this.instanceUnderTest.enableUser(user.getEmail());

    assertNotNull(result);
    verify(userRepository).enableUser(user.getEmail());
  }

  @Test
  void testFindUserById() {
    final var user = mock(User.class);

    when(userRepository.findUserById(user.getId())).thenReturn(user);

    final var result = this.instanceUnderTest.findById(user.getId());

    assertEquals(user, result);
    verify(userRepository).findUserById(user.getId());
  }

  @Test
  void testFindUserByUsername() {
    final var user = mock(User.class);

    when(userRepository.findUserByUsername(user.getUsername())).thenReturn(user);

    final var result = this.instanceUnderTest.findByUsername(user.getUsername());

    assertEquals(user, result);
    verify(userRepository).findUserByUsername(user.getUsername());
  }

  @Test
  void testLoadUserByUsername() {
    final var user = mock(User.class);

    when(userRepository.findByUsernameEqualsOrEmailEquals(user.getUsername(), user.getEmail())).thenReturn(user);

    final var result = this.instanceUnderTest.loadUserByUsername(user.getUsername());

    assertNotNull(result);
    verify(userRepository).findByUsernameEqualsOrEmailEquals(user.getUsername(), user.getEmail());
  }

}
