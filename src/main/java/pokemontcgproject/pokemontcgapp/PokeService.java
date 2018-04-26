package pokemontcgproject.pokemontcgapp;


import org.springframework.stereotype.Service;
import pokemontcgproject.pokemontcgapp.PokemonCardInfo.Card;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PokeService {
    private List<Card> cards;

    public List<Card> findCard(String name) {

        List<Card> result = cards.stream().filter(x -> x.getName().equalsIgnoreCase(name)).collect(Collectors.toList());

        return result;

    }




    @PostConstruct
    private void initCardsForTesting() {
        cards = new ArrayList<Card>();

        Card card1 = new Card("xy7-66", "Porygon", 474, "https://images.pokemontcg.io/xy7/66.png");
        Card card2 = new Card ("xy1-99", "Dodrio", 85, "https://images.pokemontcg.io/xy1/99.png");

        cards.add(card1);
        cards.add(card2);
    }



}
