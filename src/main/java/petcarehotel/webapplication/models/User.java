package petcarehotel.webapplication.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "korisnik")
public class User {
    public User() {
    }

    public User(String username, String password, String email, String firstName, String lastName, String number) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.number = number;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private String email;
    private String firstName;
    private String lastName;
    private String number;

    @OneToMany(mappedBy = "owner")
    private List<Pet> pets;

    public void addPet(Pet pet){
        pets.add(pet);
    }
}
