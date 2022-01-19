package petcarehotel.webapplication.Models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Data
@Entity
public class Pet {

    @Id
    private Long id;
    @ManyToOne
    private User owner;
}
