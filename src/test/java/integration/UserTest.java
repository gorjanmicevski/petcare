package integration;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import petcarehotel.webapplication.service.UserService;
import support.ModuleTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static support.TestObjectGenerator.generateUser;

@ModuleTest
@RequiredArgsConstructor
public class UserTest {
  private final UserService userService;

  @Test
  void testAddUser() {
    var user = generateUser();
    userService.addUser(user);

    final var result = userService.findById(user.getId());

    assertNotNull(result.getId());
  }

  @Test
  void testRegisterUser() {
    var user = generateUser();

    final var result = userService.register(user);

    assertNotNull(result);
  }

  @Test
  void testEnableUser() {
    var user = generateUser();
    userService.addUser(user);

    user = userService.findById(user.getId());

    final var result = userService.enableUser(user.getEmail());

    assertNotNull(result);
  }

  @Test
  void testGetUserById() {
    var user = generateUser();
    userService.addUser(user);

    final var result = userService.findById(user.getId());

    assertNotNull(result);
  }

  @Test
  void testGetUserByUsername() {
    var user = generateUser();
    userService.addUser(user);

    final var result = userService.findByUsername(user.getUsername());

    assertNotNull(result);
  }

  @Test
  void testLoadByUsername() {
    var user = generateUser();
    userService.addUser(user);

    final var result = userService.loadUserByUsername(user.getUsername());

    assertNotNull(result);
  }
}
