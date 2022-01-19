package petcarehotel.webapplication.Models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@Entity
public class User {
    @Id
    private Long id;
    @OneToMany(mappedBy = "owner")
    private List<Pet> pet;
}
