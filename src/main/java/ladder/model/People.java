package ladder.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class People {
    private static final String COMMA = ",";

    private List<Person> people;

    private People(String people) {
        this.people = new ArrayList<>();

        Arrays.asList(replaceSpace(people).split(COMMA)).stream()
                .forEach(name -> this.people.add(Person.of(name)));
    }

    public static People of(String names) {
        return new People(names);
    }

    public List<Person> getPeople() {
        return people;
    }

    public int count() {
        return people.size();
    }

    public Person getPersonByIndex(int index) {
        return people.get(index);
    }

    private String replaceSpace(String people) {
        return people.replace(" ", "");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        People people1 = (People) o;

        return people != null ? people.equals(people1.people) : people1.people == null;
    }

    @Override
    public int hashCode() {
        return people != null ? people.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "People{" +
                "people=" + people +
                '}';
    }
}
