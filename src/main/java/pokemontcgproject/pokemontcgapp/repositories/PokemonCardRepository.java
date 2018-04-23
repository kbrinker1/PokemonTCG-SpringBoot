package pokemontcgproject.pokemontcgapp.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import pokemontcgproject.pokemontcgapp.domain.Card;

public interface PokemonCardRepository extends CrudRepository<Card,String> {


    @Query(value = "SELECT pokemon.* " +
            "FROM Option o, Vote v " +
            "WHERE o.POLL_ID = ?1 " +
            "AND v.OPTION_ID = o.OPTION_ID", nativeQuery = true)
    public Iterable<Card> findCardsByName(String name);

}
