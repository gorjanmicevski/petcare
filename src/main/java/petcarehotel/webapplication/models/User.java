package petcarehotel.webapplication.models;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import petcarehotel.webapplication.models.enumerations.Role;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Data
@Entity
@Table(name = "korisnik")
public class User implements UserDetails {
    public User() {
    }

    public User(String username, String password, String email, String firstName, String lastName, String number) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.number = number;
        this.role= Role.ROLE_USER;
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
    @Enumerated(value = EnumType.STRING)
    private Role role;
    @OneToMany(mappedBy = "owner",fetch = FetchType.EAGER)
    private List<Pet> pets;

    @OneToMany(mappedBy = "user")
    private List<Review> reviews;

    public void addPet(Pet pet){
        pets.add(pet);
    }

    private boolean isAccountNonExpired = true;
    private boolean isAccountNonLocked = true;
    private boolean isCredentialsNonExpired = true;
    private boolean isEnabled = false;

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
