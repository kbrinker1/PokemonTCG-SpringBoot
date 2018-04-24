package pokemontcgproject.pokemontcgapp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Weakness {

    public String type;
    public String value;

    public Weakness() {
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
        return "Weakness{" +
                "type='" + type + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}