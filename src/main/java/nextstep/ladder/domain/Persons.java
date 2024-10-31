package nextstep.ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Persons {
    private static final String SPLIT_DELIMITER = ",";
    private final List<Person> persons;
    private final int maxLength;

    public Persons(String[] texts) {
        this(Arrays.stream(texts)
                .map(Person::new)
                .collect(Collectors.toList()));
    }

    public Persons(List<Person> persons) {
        this.persons = persons;
        this.maxLength = persons.stream()
                .map(person -> person.getLength())
                .max(Integer::compareTo)
                .orElse(0);
    }

    public int personCount() {
        return persons.size();
    }

    public List<Person> getPersons() {
        return persons;
    }

    public int getMaxLength() {
        return maxLength;
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
