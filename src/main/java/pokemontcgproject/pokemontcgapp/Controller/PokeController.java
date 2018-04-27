package pokemontcgproject.pokemontcgapp.Controller;


import org.springframework.web.bind.annotation.*;

@RestController
public class PokeController {

    @RequestMapping(value = "/pokemon", method = RequestMethod.GET)
    @ResponseBody
    public String getPokemon() {

        return "Potentially Pokemon";
    }

//    PokeService pokeService;
//
//    @Autowired
//    public void setPokeService(PokeService pokeService) {this.pokeService = pokeService;}
//
//
//    @PostMapping("/pokemon")
//    public ResponseEntity<?> getPokemonCards (@Valid @RequestBody Pokemon poke){
//        Card result = new Card();
//
//        List<Card> cards = pokeService.findCard("Porygon");
//        return ResponseEntity.ok(result);
//    }




}
