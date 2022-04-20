package petcarehotel.webapplication.models.enumerations;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Enumeration for the type of the pet.
 */
public enum PetType {
  DOG, CAT, PARROT;

  private static final List<PetType> VALUES =
          Collections.unmodifiableList(Arrays.asList(values()));
  private static final int SIZE = VALUES.size();
  private static final Random RANDOM = new Random();

  public static PetType getRandomPetType()  {
    return VALUES.get(RANDOM.nextInt(SIZE));
  }
}
