package junit.petcare.webapplication.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import petcarehotel.webapplication.models.Pet;
import petcarehotel.webapplication.repository.PetRepository;
import petcarehotel.webapplication.service.impl.PetServiceImpl;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static support.TestObjectGenerator.generatePet;

public class PetServiceImplTest {
  private PetServiceImpl instanceUnderTest;
  private PetRepository petRepository;

  @BeforeEach
  void init() {
    petRepository = mock(PetRepository.class);
    instanceUnderTest = new PetServiceImpl(petRepository);
  }

  @Test
  void testSavePet() {
    final var pet = generatePet();

    when(petRepository.save(any(Pet.class))).thenReturn(pet);

    this.instanceUnderTest.addPet(pet);

    verify(petRepository).save(pet);
  }

}
