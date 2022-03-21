package petcarehotel.webapplication.models;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "komentar")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String text;

    private Double rating;

    public List<Integer> getRating() {
        List<Integer> ret=new ArrayList<>();
        for (int i=1;i<=5;i++){
            if(rating>i)
                ret.add(i);
            else
                ret.add(0);

        }
        return ret;
    }

    @ManyToOne
    private User user;

    public Review() {
    }

    public Review(String text, User user, Double rating) {
        this.text = text;
        this.user = user;
        this.rating = rating;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
