//package pokemontcgproject.pokemontcgapp.DomainCardInfo;
//
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//
//import javax.persistence.*;
//
//@JsonIgnoreProperties(ignoreUnknown = true)
//@Entity
//@Table(name = "ability")
//public class Ability {
//
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    public int idAbility;
//
//    public String name;
//    public String text;
//    public String type;
//
//    @OneToOne
//    @JoinColumn(name = "card_id")
//    public Card card;
//
//    public Ability() {
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getText() {
//        return text;
//    }
//
//    public void setText(String text) {
//        this.text = text;
//    }
//
//    public String getType() {
//        return type;
//    }
//
//    public void setType(String type) {
//        this.type = type;
//    }
//
//    public int getIdAbility() {
//        return idAbility;
//    }
//
//    public void setIdAbility(int idAbility) {
//        this.idAbility = idAbility;
//    }
//
//    @Override
//    public String toString() {
//        return "Ability{" +
//                "name='" + name + '\'' +
//                ", text='" + text + '\'' +
//                ", type='" + type + '\'' +
//                '}';
//    }
//}
