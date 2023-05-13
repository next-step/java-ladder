package laddergame.domain;

import laddergame.utils.Validation;

public class Person {

    private final String name;

    public Person(final String name) {
        Validation.lengthOfName(name.length());
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
