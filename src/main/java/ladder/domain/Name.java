package ladder.domain;

import ladder.Lambda;

public class Name {

    private final String name;
    public static final int MAX_NAME_LENGTH = 5;

    public Name(String name) {
        Lambda.validateLength(name, MAX_NAME_LENGTH, (text, number) -> text.length() > number);
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
