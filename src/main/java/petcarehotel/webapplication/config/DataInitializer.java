package petcarehotel.webapplication.config;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import petcarehotel.webapplication.models.Pet;
import petcarehotel.webapplication.models.PetType;
import petcarehotel.webapplication.models.User;
import petcarehotel.webapplication.service.PetService;
import petcarehotel.webapplication.service.UserService;

import javax.annotation.PostConstruct;

@Component
public class DataInitializer {
    private final PasswordEncoder passwordEncoder;
    private final PetService petService;
    private final UserService userService;

    public DataInitializer(PasswordEncoder passwordEncoder, PetService petService, UserService service) {
        this.passwordEncoder = passwordEncoder;
        this.petService = petService;
        this.userService = service;
    }


    private PetType randomizeEventType(int i) {
        if (i % 3 == 0) return PetType.CAT;
        else if (i % 3 == 1) return PetType.DOG;
        return PetType.PARROT;
    }
    @PostConstruct
    public void initData() {
        User user1=new User("username1",passwordEncoder.encode("pass1"),"email1","name1","last1","num1");
        User user2=new User("username2",passwordEncoder.encode("pass2"),"email2","name2","last2","num2");
        User user3=new User("username3",passwordEncoder.encode("pass3"),"email3","name3","last3","num3");
        this.userService.addUser(user1);
        this.userService.addUser(user2);
        this.userService.addUser(user3);
        for (int i = 0; i < 3; i++) {
            petService.addPet(new Pet(randomizeEventType(i),"petsForUser1",user1));
        }
        for (int i = 0; i < 3; i++) {
            petService.addPet(new Pet(randomizeEventType(i),"petsForUser2",user2));
        }
        for (int i = 0; i < 3; i++) {
            petService.addPet(new Pet(randomizeEventType(i),"petsForUser3",user3));
        }
    }
}
