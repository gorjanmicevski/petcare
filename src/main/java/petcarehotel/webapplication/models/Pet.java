package petcarehotel.webapplication.models;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import petcarehotel.webapplication.models.enumerations.PetType;

/**
 * Entity class for the Pet.
 */
@Data
@Entity
@Table(name = "PET")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Pet {

  /**
   * Custom constructor.
   *
   * @param type PetType
   * @param name String
   * @param owner User
   */
  public Pet(PetType type, String name, User owner) {
    this.owner = owner;
    this.type = type;
    this.name = name;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "PET_ID")
  private Long id;
  @ManyToOne(cascade = CascadeType.MERGE)
  private User owner;
  @ManyToOne(cascade = CascadeType.MERGE)
  private User keeper;
  @Enumerated(EnumType.STRING)
  @Column(name = "PET_TYPE")
  private PetType type;
  @Column(name = "NAME")
  private String name;
}
