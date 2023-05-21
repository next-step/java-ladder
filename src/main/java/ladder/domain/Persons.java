package ladder.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Persons {
    public static final String DELIMITER = ",";
    public static final int MIN_PERSON_COUNT = 2;
    private final List<Person> persons;

    public Persons(String namesOfPersons) {
        validateNames(namesOfPersons);

        persons = Arrays.stream(namesOfPersons.split(DELIMITER))
                .map(Person::new)
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
}
