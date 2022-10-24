package ladder.domain;

import ladder.exception.person.PersonNameLengthException;

public class Person {

    private final String name;
    private final int PERSON_NAME_LENGTH_MAX = 5;

    public Person(String name) {
        if (name.length() > PERSON_NAME_LENGTH_MAX) {
            throw new PersonNameLengthException(PERSON_NAME_LENGTH_MAX);
        }
        this.name = name;
    }
}
