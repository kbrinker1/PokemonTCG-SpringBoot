package pokemontcgproject.pokemontcgapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import pokemontcgproject.pokemontcgapp.DomainCardInfo.Card;
import pokemontcgproject.pokemontcgapp.DomainCardInfo.Pokemon;
import pokemontcgproject.pokemontcgapp.Service.PokeService;

@SpringBootApplication
public class PokemonTCGApplication {

	private static final Logger log = LoggerFactory.getLogger(PokemonTCGApplication.class);

	public static void main(String args[]) {
		SpringApplication.run(PokemonTCGApplication.class);

	}






	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		return args -> {
			Card card = restTemplate.getForObject(
					"https://api.pokemontcg.io/v1/cards/xy7-54", Card.class);
			log.info(card.toString());

		};
	}

}