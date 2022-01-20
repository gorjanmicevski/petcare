package petcarehotel.webapplication.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "mileniche")
public class Pet {
    public Pet() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private User owner;
    @Enumerated(EnumType.STRING)
    private PetType type;
}
