//package pokemontcgproject.pokemontcgapp.DomainCardInfo;
//
//import java.util.List;
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//
//import javax.persistence.*;
//
//@JsonIgnoreProperties(ignoreUnknown = true)
//@Entity
//@Table(name = "attack")
//public class Attack {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//   // public List<String> cost;
//    public String name;
//    public String text;
//    public String damage;
//    public int convertedEnergyCost;
//
//
//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "Card_id")
//    private Card card;
//
//    public Attack() {
//    }
//
//    public List<String> getCost() {
//        return cost;
//    }
//
//    public void setCost(List<String> cost) {
//        this.cost = cost;
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
//    public String getDamage() {
//        return damage;
//    }
//
//    public void setDamage(String damage) {
//        this.damage = damage;
//    }
//
//    public int getConvertedEnergyCost() {
//        return convertedEnergyCost;
//    }
//
//    public void setConvertedEnergyCost(int convertedEnergyCost) {
//        this.convertedEnergyCost = convertedEnergyCost;
//    }
//
//    @Override
//    public String toString() {
//        return "Attack{" +
//               // "cost=" + cost +
//                ", name='" + name + '\'' +
//                ", text='" + text + '\'' +
//                ", damage='" + damage + '\'' +
//                ", convertedEnergyCost=" + convertedEnergyCost +
//                '}';
//    }
//}
