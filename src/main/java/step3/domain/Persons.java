package step3.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
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


    public Person get(int index) {
        return persons.get(index);
    }

    public int getPersonIndex(Person person) {
        int position = 0;
        for(int i = 0; i < persons.size(); i++) {
            if (get(i).equals(person)) {
                position = i;
            }
        }
        return position;
    }

    public int size() {
        return persons.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Persons persons1 = (Persons) o;
        return Objects.equals(persons, persons1.persons);
    }

    @Override
    public int hashCode() {
        return Objects.hash(persons);
    }
}