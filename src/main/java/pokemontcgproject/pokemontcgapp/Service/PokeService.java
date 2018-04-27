package pokemontcgproject.pokemontcgapp.Service;


import org.springframework.stereotype.Service;
import pokemontcgproject.pokemontcgapp.DomainCardInfo.Card;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Service
public class PokeService {
    private List<Card> cards;

//    public List<Card> findCard(String name) {
//
//        List<Card> result = cards.stream().filter(x -> x.getName().equalsIgnoreCase(name)).collect(Collectors.toList());
//
//        return result;
//
//    }


    private String BaseUrl;
    private String ResponderUrl;
    private String responderParameter;


    public PokeService() {
        this.BaseUrl = "https://api.pokemontcg.io/v1/cards/";
        this.ResponderUrl = "/{set}-{id)";
        this.responderParameter = responderParameter; //json??
    }

    private void sendGet() throws Exception {
        String url = "https://api.pokemontcg.io/v1/cards/";
        URL obj = new URL(url);
        HttpURLConnection connect = (HttpURLConnection) obj.openConnection();
        connect.setRequestMethod("GET");
        connect.setRequestProperty("Content-Type", "application/json");
        connect.setRequestProperty("Accept", "application/json");


        int responseCode = connect.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(connect.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        //print result
        System.out.println(response.toString());

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
