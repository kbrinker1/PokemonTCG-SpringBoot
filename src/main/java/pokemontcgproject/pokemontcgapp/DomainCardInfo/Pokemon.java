package pokemontcgproject.pokemontcgapp.DomainCardInfo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Pokemon {
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
