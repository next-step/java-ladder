package ladder.domain;

import ladder.exception.InvalidNameException;

public class Person {

    public static final int MAX_LENGTH = 5;
    private static final String MESSAGE_NULL_OR_BLANK = "이름은 공란이거나 Null 일 수 없습니다.";

    private final String name;

    public Person(String name) {
        if (isNullOrBlank(name)) {
            throw new InvalidNameException(MESSAGE_NULL_OR_BLANK);
        }
        if (isLowerMaxLength(name)) {
            throw new InvalidNameException();
        }
        this.name = name;
    }

    private boolean isNullOrBlank(String name) {
        return name == null || name.isBlank();
    }

    private boolean isLowerMaxLength(String value) {
        return value.length() > MAX_LENGTH;
    }
}
