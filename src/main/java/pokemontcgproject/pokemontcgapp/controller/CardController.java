package pokemontcgproject.pokemontcgapp.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pokemontcgproject.pokemontcgapp.domain.Card;
import pokemontcgproject.pokemontcgapp.repositories.PokemonCardRepository;

import javax.inject.Inject;


@RestController
public class CardController {

    @Inject
    private PokemonCardRepository pokemonCardRepository;

    @RequestMapping(value = "/cards",method = RequestMethod.GET)
    public ResponseEntity<Iterable<Card>> findCard(){
        Iterable<Card> allCards = pokemonCardRepository.findAll();
        return new ResponseEntity<>(allCards, HttpStatus.OK);
    }

    @RequestMapping(value="/polls/{pollId}/votes", method=RequestMethod.GET)
    public Iterable<Card> getAllCards(@PathVariable String name) {
        return pokemonCardRepository.findCardsByName(name);
    }


}
