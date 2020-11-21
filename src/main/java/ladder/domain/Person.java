package ladder.domain;

import ladder.dto.PersonDto;
import ladder.exception.BadNameException;

import java.util.Objects;

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

    PersonDto exportPersonDto() {
        return new PersonDto(name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Person person = (Person) o;
        return Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
