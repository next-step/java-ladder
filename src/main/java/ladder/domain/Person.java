package ladder.domain;

import ladder.util.ErrorMessage;

public class Person {
    private static final int MAX_NAME_LENGTH = 5;

    private String name;

    public Person(String name) {
        checkName(name);

        this.name = name;
    }

    private void checkName(final String name) {
        checkEmpty(name);
        checkNameLength(name);
    }

    private void checkEmpty(final String names) {
        if (names == null) {
            throw new RuntimeException(ErrorMessage.getCheckInputNames());
        }
    }

    private void checkNameLength(final String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new RuntimeException(ErrorMessage.getCheckNameLength());
        }
    }

    public String getName() {
        return name;
    }
}
