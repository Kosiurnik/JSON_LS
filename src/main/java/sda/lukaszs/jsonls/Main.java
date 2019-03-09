package sda.lukaszs.jsonls;

import com.fasterxml.jackson.databind.ObjectMapper;
import sda.lukaszs.jsonls.model.Address;
import sda.lukaszs.jsonls.model.Person;
import sda.lukaszs.jsonls.model.Student;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
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

        //tworzę plik json dla każdego obiektu
        makeJSON("person",person);
        makeJSON("people",people);
        makeJSON("students",students);

        //tworzę obiekty z plików json'a
        Person person1 = makeObjectFromJSON(new File("jsonOut/person.json"),Person.class);
        List<Person> people2 = makeObjectListFromJSON(new File("jsonOut/people.json"),Person[].class);
        List<Student> students2 = makeObjectListFromJSON(new File("jsonOut/students.json"),Student[].class);
        System.out.println(person1);
        System.out.println(people2);
        System.out.println(students2);

    }

    //tworzy obiekt z dowolnego json'a o określonej klasie
    private static <T> T makeObjectFromJSON(File file, Class<T> clazz) {
        ObjectMapper mapper = new ObjectMapper();
        T output = null;
        try {
            output = mapper.readValue(file, clazz);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return output;
    }

    //tworzy listę obiektów z dowolnego json'a o określonej klasie
    private static <T> List<T> makeObjectListFromJSON(File file, Class<T[]> clazz){
        ObjectMapper mapper = new ObjectMapper();
        List<T> output = new ArrayList<>();
        T[] outArray;
        try {
            outArray = mapper.readValue(file,clazz);
            output = Arrays.asList(outArray);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return output;
    }

    //tworzy plik json dla dowolnego obiektu
    private static <T> void makeJSON(String filename, T object){
        ObjectMapper mapper = new ObjectMapper();
        try {
            String p1JsonString = mapper.writeValueAsString(object);
            Files.write(Paths.get("jsonOut/"+filename+".json"),p1JsonString.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
