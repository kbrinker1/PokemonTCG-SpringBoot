package pokemontcgproject.pokemontcgapp.DomainCardInfo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;


@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = "pokemon")
public class Pokemon {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;

    @OneToOne
    public Card card;



    public Pokemon() {

    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }



    @Override
    public String toString() {
        return "Pokemon{" +
                "card=" + card +
                '}';
    }
}
