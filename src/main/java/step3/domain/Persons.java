package step3.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Persons {
    private static final String COMMA = ",";
    private List<Person> persons;

    public Persons(String persons) {
        this.persons = createPersons(persons);
    }

    public Persons(final List<Person> persons) {
        this.persons = persons;
    }

    public List<Person> createPersons(String inputNames) {
        String[] inputPersons = inputNames.trim().split(COMMA);
        return Arrays.asList(inputPersons)
                .stream()
                .map(Person::new)
                .collect(Collectors.toList());
    }

    public List<Person> personList() {
        return Collections.unmodifiableList(this.persons);
    }


}