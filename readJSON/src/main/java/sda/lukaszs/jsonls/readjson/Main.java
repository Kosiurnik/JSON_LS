package sda.lukaszs.jsonls.readjson;

import sda.lukaszs.jsonls.model.Person;
import sda.lukaszs.jsonls.model.Student;

import java.io.File;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //tworzę obiekty z plików json'a
        Person person = ReadJSON.makeObjectFromJSON(new File("jsonOut/person.json"),Person.class);
        Student student = ReadJSON.makeObjectFromJSON(new File("jsonOut/student.json"),Student.class);
        List<Person> people = ReadJSON.makeObjectListFromJSON(new File("jsonOut/people.json"),Person[].class);
        List<Student> students = ReadJSON.makeObjectListFromJSON(new File("jsonOut/students.json"),Student[].class);
        System.out.println(person);
        System.out.println(student);
        System.out.println(people);
        System.out.println(students);
    }
}
