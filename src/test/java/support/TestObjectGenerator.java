package support;

import lombok.experimental.UtilityClass;
import petcarehotel.webapplication.models.Pet;
import petcarehotel.webapplication.models.Review;
import petcarehotel.webapplication.models.User;

import java.util.Random;

import static java.util.UUID.randomUUID;
import static petcarehotel.webapplication.models.enumerations.PetType.getRandomPetType;
import static petcarehotel.webapplication.models.enumerations.Role.getRandomRole;

@UtilityClass
public class TestObjectGenerator {

    public static Pet generatePet() {
        Pet pet = new Pet();

        User owner = generateUser();
        pet.setOwner(owner);

        User keeper = generateUser();
        pet.setKeeper(keeper);

        pet.setType(getRandomPetType());
        pet.setName(randomUUID().toString());

        return pet;
    }

    public static User generateUser() {
        User user = new User();

        user.setUsername(randomUUID().toString());
        user.setPassword(randomUUID().toString());
        user.setEmail(randomUUID().toString());
        user.setFirstName(randomUUID().toString());
        user.setLastName(randomUUID().toString());
        user.setNumber(randomUUID().toString());
        user.setRole(getRandomRole());

        return user;
    }

    public static Review generateReview() {
        Review review = new Review();

        review.setText(randomUUID().toString());

        Random r = new Random();
        int rangeMin = 1;
        int rangeMax = 10;
        double randomValue = rangeMin + (rangeMax - rangeMin) * r.nextDouble();
        review.setRating(randomValue);

        User user = generateUser();
        review.setUser(user);

        return review;
    }
}
