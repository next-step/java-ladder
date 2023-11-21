package ladder.domain;

import java.util.Arrays;
import java.util.List;

import ladder.domain.exception.LadderException;

public class PersonNames {

    private final List<String> personNames;

    public PersonNames(String[] personNames) {
        validate(personNames);
        this.personNames = Arrays.asList(personNames);
    }

    private void validate(String[] personNames) {
        if (!isValid(personNames)) {
            throw new LadderException("사람 이름은 최대 5자 입니다.");
        }
    }

    private static boolean isValid(String[] personNames) {
        return Arrays.stream(personNames)
            .allMatch(PersonNames::validLength);
    }

    private static boolean validLength(String name) {
        return name.length() <= 5;
    }
}
