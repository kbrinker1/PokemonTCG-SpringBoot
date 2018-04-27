//package pokemontcgproject.pokemontcgapp.DomainCardInfo;
//
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//
//import javax.persistence.*;
//
//@JsonIgnoreProperties(ignoreUnknown = true)
//@Entity
//@Table(name = "resistance")
//public class Resistance {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private int id;
//
//    public String type;
//    public String value;
//
//    @OneToOne
//    @JoinColumn(name = "card_id")
//    private Card card;
//
//    public Resistance() {
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
//    public String getValue() {
//        return value;
//    }
//
//    public void setValue(String value) {
//        this.value = value;
//    }
//
//    @Override
//    public String toString() {
//        return "Resistance{" +
//                "type='" + type + '\'' +
//                ", value='" + value + '\'' +
//                '}';
//    }
//}