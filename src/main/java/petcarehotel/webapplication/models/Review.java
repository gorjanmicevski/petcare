package petcarehotel.webapplication.models;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
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

/**
 * Entity for the Review.
 */
@Data
@Entity
@Table(name = "REVIEW")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Review {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "REVIEW_ID")
  private Long id;

  @Column(name = "TEXT")
  private String text;

  @Column(name = "RATING")
  private Double rating;

  @ManyToOne
  private User user;

  /**
   * Custom constructor.
   *
   * @param text   String
   * @param user   User
   * @param rating Double
   */
  public Review(String text, User user, Double rating) {
    this.text = text;
    this.user = user;
    this.rating = rating;
  }

  /**
   * Custom method for getting the rating.
   *
   * @return List
   */
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

  public double getRatingDouble() {
    return rating;
  }
}
