package ladder.domain;

import ladder.dto.response.PersonDto;
import ladder.exception.BadNameException;

public class Person {
    private static final int STANDARD_NAME_LENGTH = 5;

    private final String name;

    public Person(String name) {
        this.name = name;
        validate();
    }

    private void validate() {
        if (name.length() > STANDARD_NAME_LENGTH) {
            throw BadNameException.getInstance();
        }
    }

    PersonDto getPersonDto() {
        return new PersonDto(STANDARD_NAME_LENGTH, name);
    }
}
