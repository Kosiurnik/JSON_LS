package sda.lukaszs.jsonls;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import sda.lukaszs.jsonls.model.Address;
import sda.lukaszs.jsonls.model.Person;
import sda.lukaszs.jsonls.model.Student;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Person person = new Person("Łukasz","Świetlik",26);

        List<Person> people = new ArrayList<>();
        people.add(new Person("Jan","Kowalski",28));
        people.add(new Person("Zbyszek","Jaworski",32));
        people.add(new Person("Jolanta","Gabrowska",29));
        people.add(new Person("Aneta","Adamowicz",30));

        List<Student> students = new ArrayList<>();
        students.add(new Student("Jan","Kowalski",new Address("Bydgoszcz","Jagiellońska 12")));
        students.add(new Student("Adam","Jary",new Address("Toruń","Wiejska 11")));
        students.add(new Student("Katarzyna","Witkowska",new Address("Kraków","Krakowska 1")));
        students.add(new Student("Natalia","Bielicka",new Address("Gdańsk","Morska 3")));

        makeJSON("person",person);
        makeJSON("people",people);
        makeJSON("students",students);
    }

    private static void makeJSON(String filename, Object object){
        ObjectMapper mapper = new ObjectMapper();
        try {
            String p1JsonString = mapper.writeValueAsString(object);
            Files.write(Paths.get("jsonOut/"+filename+".json"),p1JsonString.getBytes());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
