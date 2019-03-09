package sda.lukaszs.jsonls.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Address {
    private String city;
    private String street;

    public Address(){}

    @Override
    public String toString() {
        return String.format("%s %s", city, street);
    }
}
