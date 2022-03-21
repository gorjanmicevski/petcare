package petcarehotel.webapplication.config;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import petcarehotel.webapplication.models.Pet;
import petcarehotel.webapplication.models.Review;
import petcarehotel.webapplication.models.enumerations.PetType;
import petcarehotel.webapplication.models.User;
import petcarehotel.webapplication.service.PetService;
import petcarehotel.webapplication.service.ReviewService;
import petcarehotel.webapplication.service.UserService;

import javax.annotation.PostConstruct;

@Component
public class DataInitializer {
    private final PasswordEncoder passwordEncoder;
    private final PetService petService;
    private final UserService userService;
    private final ReviewService reviewService;
    public DataInitializer(PasswordEncoder passwordEncoder, PetService petService, UserService service, ReviewService reviewService) {
        this.passwordEncoder = passwordEncoder;
        this.petService = petService;
        this.userService = service;
        this.reviewService=reviewService;
    }


    private PetType randomizeEventType(int i) {
        if (i % 3 == 0) return PetType.CAT;
        else if (i % 3 == 1) return PetType.DOG;
        return PetType.PARROT;
    }
    @PostConstruct
    public void initData() {
        //init users
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
        //init reviews
        String loerm="Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";
        //Caused by: org.h2.jdbc.JdbcSQLDataException: Value too long for column "TEXT VARCHAR(255)": "'Lorem ipsum dolor sit amet,.....
        String pomalLorem=" enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur";
        this.reviewService.create(pomalLorem,user1,4.6);
        this.reviewService.create(pomalLorem,user2,3.6);
        this.reviewService.create(pomalLorem,user3,2.6);

    }
}
