package ladder.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Persons {
    private static final String PERSON_EMPTY_ERROR = "참여자가 없습니다.";
    private static final String PERSON_MINIMUN_COUNT_ERROR = "최소 2명 이상 참가해야합니다.";
    private static final int PERSON_MINIMUN_COUNT = 2;

    private final List<Person> persons;

    public Persons(String inputPerson) {
        validEmpty(inputPerson);
        this.persons = stringToList(inputPerson);
    }

    private List<Person> stringToList(String inputText) {
        String[] names = inputText.split(",");
        validPersonSizeTwoUnder(names.length);
        return Arrays.stream(names)
                .map(Person::new)
                .collect(Collectors.toList());
    }

    private static void validPersonSizeTwoUnder(int length) {
        if (length < PERSON_MINIMUN_COUNT) {
            throw new IllegalArgumentException(PERSON_MINIMUN_COUNT_ERROR);
        }
    }

    private static void validEmpty(String inputText) {
        if (inputText == null
                || inputText.trim().isEmpty()) {
            throw new IllegalArgumentException(PERSON_EMPTY_ERROR);
        }
    }

    public int countOfPersons() {
        return persons.size();
    }

    public List<Person> readOnlyPersons() {
        return Collections.unmodifiableList(persons);
    }
}
