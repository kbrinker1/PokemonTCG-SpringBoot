package pokemontcgproject.pokemontcgapp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Card {


    @Id
    @GeneratedValue
    @Column(name = "POKEMON")
    private String name;

    public String getName(){
        return name;
    }

    public void setName(){
        this.name = name;
    }



}
