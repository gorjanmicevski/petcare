package petcarehotel.webapplication.models;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
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

@Data
@Entity
@Table(name = "komentar")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Review {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String text;

  private Double rating;

  public List<Integer> getRating() {
    List<Integer> ret = new ArrayList<>();
    for (int i = 1; i <= 5; i++) {
        if (rating > i) {
            ret.add(i);
        } else {
            ret.add(0);
        }

    }
    return ret;
  }

  @ManyToOne
  private User user;

  public Review(String text, User user, Double rating) {
    this.text = text;
    this.user = user;
    this.rating = rating;
  }
}
