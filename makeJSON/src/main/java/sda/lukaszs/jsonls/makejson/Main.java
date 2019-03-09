package sda.lukaszs.jsonls.makejson;

import sda.lukaszs.jsonls.model.Address;
import sda.lukaszs.jsonls.model.Person;
import sda.lukaszs.jsonls.model.Student;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Person person = new Person("Łukasz","Świetlik",26);
        Student student = new Student("Piotr","Rozwarski",new Address("Poznań","Żaglowa 41"));

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

        MakeJSON.makeJSONFile("jsonOut/person.json",person);
        MakeJSON.makeJSONFile("jsonOut/student.json",student);
        MakeJSON.makeJSONFile("jsonOut/people.json",people);
        MakeJSON.makeJSONFile("jsonOut/students.json",students);
    }
}
