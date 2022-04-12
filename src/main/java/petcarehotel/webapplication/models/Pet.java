package petcarehotel.webapplication.models;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import petcarehotel.webapplication.models.enumerations.PetType;

@Data
@Entity
@Table(name = "mileniche")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Pet {

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
