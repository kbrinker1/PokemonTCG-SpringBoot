package pokemontcgproject.pokemontcgapp.DomainCardInfo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Resistance {

    public String type;
    public String value;

    public Resistance() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Resistance{" +
                "type='" + type + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}