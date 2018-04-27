package pokemontcgproject.pokemontcgapp.DomainCardInfo;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = "card")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int idCard;

    public String id;
    public String name;
    public int nationalPokedexNumber;
    public String imageUrl;
    public String imageUrlHiRes;
    public String supertype;
    public String subtype;
    public String evolvesFrom;
    public String hp;
    public String number;
    public String artist;
    public String rarity;
    public String series;
    public String set;
    public String setCode;

    @OneToOne
    @JoinColumn(name = "pokemon_card")
    private Pokemon pokemon;

    public Card() {
    }

    public Card(String id, String name, int nationalPokedexNumber, String imageUrl) {
        this.id = id;
        this.name = name;
        this.nationalPokedexNumber = nationalPokedexNumber;
        this.imageUrl = imageUrl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNationalPokedexNumber() {
        return nationalPokedexNumber;
    }

    public void setNationalPokedexNumber(int nationalPokedexNumber) {
        this.nationalPokedexNumber = nationalPokedexNumber;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImageUrlHiRes() {
        return imageUrlHiRes;
    }

    public void setImageUrlHiRes(String imageUrlHiRes) {
        this.imageUrlHiRes = imageUrlHiRes;
    }

    public String getSupertype() {
        return supertype;
    }

    public void setSupertype(String supertype) {
        this.supertype = supertype;
    }

    public String getSubtype() {
        return subtype;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

    public String getEvolvesFrom() {
        return evolvesFrom;
    }

    public void setEvolvesFrom(String evolvesFrom) {
        this.evolvesFrom = evolvesFrom;
    }

    public String getHp() {
        return hp;
    }

    public void setHp(String hp) {
        this.hp = hp;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getRarity() {
        return rarity;
    }

    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getSet() {
        return set;
    }

    public void setSet(String set) {
        this.set = set;
    }

    public String getSetCode() {
        return setCode;
    }

    public void setSetCode(String setCode) {
        this.setCode = setCode;
    }

    public Pokemon getPokemon() {
        return pokemon;
    }

    public void setPokemon(Pokemon pokemon) {
        this.pokemon = pokemon;
    }


    @Override
    public String toString() {
        return "Card{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", nationalPokedexNumber=" + nationalPokedexNumber +
                ", imageUrl='" + imageUrl + '\'' +
                ", imageUrlHiRes='" + imageUrlHiRes + '\'' +
                ", supertype='" + supertype + '\'' +
                ", subtype='" + subtype + '\'' +
                ", evolvesFrom='" + evolvesFrom + '\'' +
                ", hp='" + hp + '\'' +
                ", number='" + number + '\'' +
                ", artist='" + artist + '\'' +
                ", rarity='" + rarity + '\'' +
                ", series='" + series + '\'' +
                ", set='" + set + '\'' +
                ", setCode='" + setCode + '\'' +
                '}';
    }
}
