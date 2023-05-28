package ladder.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Persons {
    public static final String DELIMITER = ",";
    public static final int MIN_PERSON_COUNT = 2;
    private final List<Person> persons;

    public Persons(String namesOfPersons) {
        validateNames(namesOfPersons);

        String[] names = namesOfPersons.split(DELIMITER);

        persons = IntStream.range(0, names.length)
                .mapToObj(i -> new Person(names[i], i))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    private void validateNames(String namesOfPersons) {
        if (namesOfPersons == null || namesOfPersons.trim().isEmpty()) {
            throw new IllegalArgumentException("이름이 입력되지 않았습니다.");
        }

        if (namesOfPersons.split(DELIMITER).length < MIN_PERSON_COUNT) {
            throw new IllegalArgumentException("이름은 2개 이상 입력되어야 합니다.");
        }
    }

    public int getCount() {
        return persons.size();
    }

    public String[] getNames() {
        return persons.stream()
                .map(Person::toString)
                .toArray(String[]::new);
    }
}
