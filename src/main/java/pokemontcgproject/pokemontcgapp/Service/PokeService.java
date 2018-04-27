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

    public List<Card> getPokemon (String set, int id) throws IOException {
        List<Card> list = new ArrayList<>();
        String url = "https://api.pokemontcg.io/v1/cards/"+set+"-"+id;
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

        return pkmnCard;
    }

}



//private List<Card> cards;
//    public List<Card> findCard(String name) {
//        List<Card> result = cards.stream().filter(x -> x.getName().equalsIgnoreCase(name)).collect(Collectors.toList());
//        return result;
//    }
//    private String BaseUrl;
//    private String ResponderUrl;
//    private String responderParameter;
//    public PokeService() {
//        this.BaseUrl = "https://api.pokemontcg.io/v1/cards/";
//        this.ResponderUrl = "/{set}-{id)";
//        this.responderParameter = responderParameter; //json??
//    }
//    private void sendGet() throws Exception {
//        String url = "https://api.pokemontcg.io/v1/cards/";
//        URL obj = new URL(url);
//        HttpURLConnection connect = (HttpURLConnection) obj.openConnection();
//        connect.setRequestMethod("GET");
//        connect.setRequestProperty("Content-Type", "application/json");
//        connect.setRequestProperty("Accept", "application/json");
//        int responseCode = connect.getResponseCode();
//        System.out.println("\nSending 'GET' request to URL : " + url);
//        System.out.println("Response Code : " + responseCode);
//        BufferedReader in = new BufferedReader(
//                new InputStreamReader(connect.getInputStream()));
//        String inputLine;
//        StringBuffer response = new StringBuffer();
//        while ((inputLine = in.readLine()) != null) {
//            response.append(inputLine);
//        }
//        in.close();
//        //print result
//        System.out.println(response.toString());
//    }
//    @PostConstruct
//    private void initCardsForTesting() {
//        cards = new ArrayList<Card>();
//        Card card1 = new Card("xy7-66", "Porygon", 474, "https://images.pokemontcg.io/xy7/66.png");
//        Card card2 = new Card ("xy1-99", "Dodrio", 85, "https://images.pokemontcg.io/xy1/99.png");
//        cards.add(card1);
//        cards.add(card2);
//    }




