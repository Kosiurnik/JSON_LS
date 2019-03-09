package sda.lukaszs.jsonls.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student {
    private String name;
    private String lastName;
    private Address address;

    public Student(){}

    @Override
    public String toString() {
        return String.format("%s %s", name, lastName);
    }
}
