package ladder.domain;

import ladder.util.ErrorMessage;

import java.util.Objects;

public class Person {
    private static final int MAX_NAME_LENGTH = 5;

    private String name;
    private int position = 0;

    public Person(String name) {
        checkName(name);

        this.name = name;
    }

    public Person(String name, int position) {
        checkName(name);

        this.name = name;
        this.position = position;
    }

    private void checkName(final String name) {
        checkEmpty(name);
        checkNameLength(name);
    }

    private void checkEmpty(final String names) {
        if (Objects.isNull(names)) {
            throw new RuntimeException(ErrorMessage.getCheckInputNames());
        }
    }

    private void checkNameLength(final String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new RuntimeException(ErrorMessage.getCheckNameLength());
        }
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
