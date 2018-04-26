package pokemontcgproject.pokemontcgapp.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pokemontcgproject.pokemontcgapp.PokeService;
import pokemontcgproject.pokemontcgapp.PokemonCardInfo.Card;
import pokemontcgproject.pokemontcgapp.PokemonCardInfo.Pokemon;

import javax.validation.Valid;
import java.util.List;

@RestController
public class PokeController {
    PokeService pokeService;

    @Autowired
    public void setPokeService(PokeService pokeService) {this.pokeService = pokeService;}

    @PostMapping("/pokemon")
    public ResponseEntity<?> getPokemonCards (@Valid @RequestBody Pokemon poke){
        Card result = new Card();

        List<Card> cards = pokeService.findCard("Porygon");
        return ResponseEntity.ok(result);
    }




}
