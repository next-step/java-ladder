package ladder.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Persons {
    private final List<Person> persons;

    private Persons(final List<Person> persons) {
        this.persons = persons;
    }

    public static Persons from(String[] personNames) {
        validate(personNames.length, (int) Arrays.stream(personNames)
                                                 .distinct()
                                                 .count());
        return Arrays.stream(personNames)
                .map(Person::from)
                .distinct()
                .collect(Collectors.collectingAndThen(Collectors.toList(),
                        Persons::new));
    }

    private static void validate(int originalSize, int distinctSize) {
        if (originalSize != distinctSize) {
            throw new RuntimeException("참여할 사람 이름은 중복으로 입력할 수 없습니다.");
        }
    }

    public List<Person> getPersons() {
        return Collections.unmodifiableList(persons);
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
