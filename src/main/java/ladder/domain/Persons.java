package ladder.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Persons {

    private final static String DELIMITER = ",";
    private final static String DELIMITER_ERROR_MESSAGE = "구분자는 ,를 입력해주세요.";
    private final static int MIN_PERSON_NUMBERS = 2;
    private final static String MIN_PERSON_NUMBERS_ERROR_MESSAGE = "참여 인원은 2명이상이어야 합니다.";
    private final List<Person> persons;

    public Persons(String... input) {
        this(Arrays.stream(input)
                .map(Person::new)
                .collect(Collectors.toList()));
    }

    public Persons(String input) {
        this(Arrays.stream(parse(input))
                .map(Person::new)
                .collect(Collectors.toList()));
    }

    public Persons(List<Person> persons) {
        this.persons = persons;
    }

    public int getSize() {
        return persons.size();
    }

    public List<Person> getPersons() {
        return Collections.unmodifiableList(this.persons);
    }

    private static String[] parse(String input) {
        return validatePersonCount(validateSplit(input).split(DELIMITER));
    }

    private static String[] validatePersonCount(String[] personArr) {
        if (personArr.length < MIN_PERSON_NUMBERS) {
            throw new IllegalArgumentException(MIN_PERSON_NUMBERS_ERROR_MESSAGE);
        }
        return personArr;
    }

    private static String validateSplit(String input) {
        if (input.contains(DELIMITER)) {
            return input;
        }
        throw new IllegalArgumentException(DELIMITER_ERROR_MESSAGE);
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
