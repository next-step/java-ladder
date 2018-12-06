package Ladder;

import java.util.ArrayList;
import java.util.List;

public class Persons {
    private static final String DELIMETER = ",";
    private List<Person> persons = new ArrayList<>();


    public Persons(String persons) throws Exception {
        String[] manyPerson = persons.split(DELIMETER);
        for (String name : manyPerson) {
            this.persons.add(new Person(name));
        }

    }

    public int personCount() {
        return this.persons.size();
    }

    public Person getOnePerson(int number) {
        return persons.get(number);
    }

    @Override
    public String toString() {
        StringBuilder nameString = new StringBuilder();
        this.persons.stream().forEach(person -> nameString.append(person.toString() + "  "));
        return nameString.toString();

    }
}