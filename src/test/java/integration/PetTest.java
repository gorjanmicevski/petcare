package integration;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import petcarehotel.webapplication.service.PetService;
import petcarehotel.webapplication.service.UserService;
import support.AbstractIntegrationTest;
import support.ModuleTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static support.TestObjectGenerator.generateIntegrationPet;
import static support.TestObjectGenerator.generateUser;

@ModuleTest
@RequiredArgsConstructor
public class PetTest  extends AbstractIntegrationTest {
  private final PetService petService;
  private final UserService userService;


  @Test
  void testAddPet() {
    final var pet = generateIntegrationPet();

    final var owner = generateUser();
    userService.addUser(owner);
    pet.setOwner(owner);

    final var keeper = generateUser();
    userService.addUser(keeper);
    pet.setKeeper(keeper);

    petService.addPet(pet);

    assertNotNull(pet.getId());
  }



}
