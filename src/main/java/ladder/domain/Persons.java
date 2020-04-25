package ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Persons {
    private List<Person> persons;

    private Persons(String[] personNames) {
        this.persons = Arrays.stream(personNames)
                .map(Person::getInstanceByName)
                .collect(Collectors.toList());
    }

    public static Persons getInstance(String[] personNames) {
        return new Persons(personNames);
    }

    public List<String> getNames() {
        return persons.stream()
                .map(Person::getName)
                .collect(Collectors.toList());
    }

    public int getCount() {
        return persons.size();
    }
}
