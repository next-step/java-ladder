package ladder.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Persons {
    private static final String PERSON_EMPTY_ERROR = "참여자가 없습니다.";
    private static final String PERSON_MINIMUN_COUNT_ERROR = "최소 2명 이상 참가해야합니다.";
    private static final String NAME_MAX_LENGTH_ERROR = "사람 이름은 최대 5글자 입니다.";
    private static final int PERSON_MINIMUN_COUNT = 2;
    private static final int NAME_MAX_LENGTH = 5;

    private final List<String> persons;

    public Persons(String inputPerson) {
        validEmpty(inputPerson);
        this.persons = stringToList(inputPerson);
    }

    private List<String> stringToList(String inputText) {
        String[] names = inputText.split(",");
        validPersonSizeTwoUnder(names.length);
        return Arrays.stream(names)
                .map(this::validNameLengthFiveOver)
                .collect(Collectors.toList());
    }

    private void validPersonSizeTwoUnder(int length) {
        if (length < PERSON_MINIMUN_COUNT) {
            throw new IllegalArgumentException(PERSON_MINIMUN_COUNT_ERROR);
        }
    }

    private void validEmpty(String inputText) {
        if (inputText == null
                || inputText.trim().isEmpty()) {
            throw new IllegalArgumentException(PERSON_EMPTY_ERROR);
        }
    }

    private String validNameLengthFiveOver(String name) {
        if (name.isEmpty()
                || name.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException(NAME_MAX_LENGTH_ERROR);
        }
        return name;
    }

    public int countOfPersons() {
        return persons.size();
    }

    public List<String> readOnlyPersons() {
        return Collections.unmodifiableList(persons);
    }
}
