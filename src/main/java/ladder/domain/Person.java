package ladder.domain;

import ladder.dto.PersonDto;
import ladder.exception.BadNameException;

import static ladder.asset.LadderConst.STANDARD_LENGTH;

public class Person {
    private final String name;

    public Person(String name) {
        this.name = name;
        validate();
    }

    private void validate() {
        if (name.length() > STANDARD_LENGTH) {
            throw BadNameException.getInstance();
        }
    }

    PersonDto getPersonDto() {
        return new PersonDto(name);
    }
}
