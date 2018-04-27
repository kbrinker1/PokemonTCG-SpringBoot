package pokemontcgproject.pokemontcgapp.Service;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pokemontcgproject.pokemontcgapp.DomainCardInfo.Card;
import pokemontcgproject.pokemontcgapp.Repository.PokeRepo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class PokeService {

    private PokeRepo repo;
    private ObjectMapper mapper;
    private HttpHeaders headers;

    @Autowired
    public PokeService (PokeRepo repo, ObjectMapper mapper){
        this.repo = repo;
        this.mapper = mapper;
        this.headers = new HttpHeaders();
    }

    public List<Card> getPokemon (String name) throws IOException {
        List<Card> list = new ArrayList<>();
        String url = "https://api.pokemontcg.io/v1/cards?name="+name;
        String pokejson = callApi(url).getBody();
        pokemonResultsList(pokejson,list);
        return list;
    }

    private ResponseEntity<String> callApi(String url) {
        HttpEntity entity = new HttpEntity(headers);
        RestTemplate template = new RestTemplate();
        return template.exchange(url, HttpMethod.GET, entity, String.class);
    }

    private void pokemonResultsList(String pokejson, List<Card> list) throws IOException {
        JsonNode response = mapper.readTree(pokejson);
        JsonNode pokemonCards = response.path("cards");
        for(JsonNode node : pokemonCards){
            Card pkmnCard = createPokeCard(node);
            list.add(pkmnCard);
            repo.save(pkmnCard);
        }
    }

    private Card createPokeCard (JsonNode node){
        Card pkmnCard = new Card();
        pkmnCard.setId(node.path("id").asText());
        pkmnCard.setName(node.path("name").asText());
        pkmnCard.setNationalPokedexNumber(node.path("nationalPokedexNumber").asInt());
        pkmnCard.setImageUrlHiRes(node.path("imageUrlHiRes").asText());

        return pkmnCard;
    }

}




