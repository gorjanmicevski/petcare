package petcarehotel.webapplication.models;

import lombok.Data;
import petcarehotel.webapplication.models.enumerations.PetType;

import javax.persistence.*;

@Data
@Entity
@Table(name = "mileniche")
public class Pet {

    public Pet() {
    }

    public Pet(PetType type, String name, User owner) {
        this.owner = owner;
        this.type = type;
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private User owner;
    @ManyToOne
    private User keeper;
    @Enumerated(EnumType.STRING)
    private PetType type;
    private String name;
}
