package sda.lukaszs.jsonls.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Person {
    private String name;
    private String lastName;
    private int age;

    public Person(){}

    @Override
    public String toString() {
        return String.format("%s %s", name, lastName);
    }
}
