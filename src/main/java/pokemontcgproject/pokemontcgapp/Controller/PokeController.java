package pokemontcgproject.pokemontcgapp.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pokemontcgproject.pokemontcgapp.Service.PokeService;

import java.io.IOException;

@RestController
public class PokeController {

    private PokeService pokeService;

    @Autowired
    public PokeController(PokeService pokeService){
        this.pokeService = pokeService;
    }

    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public ResponseEntity<?> getPokemon(@PathVariable("name") String name){

        try {
            return new ResponseEntity<>(pokeService.getPokemon(name), HttpStatus.OK);
        }
        catch(IOException ioe){
            return new ResponseEntity<>(ioe.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
