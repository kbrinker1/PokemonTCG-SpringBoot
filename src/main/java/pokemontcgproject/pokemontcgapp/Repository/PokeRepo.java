package pokemontcgproject.pokemontcgapp.Repository;


import pokemontcgproject.pokemontcgapp.DomainCardInfo.*;
import org.springframework.data.repository.CrudRepository;


public interface PokeRepo extends CrudRepository<Card, String> {



    }

