package ladder.domain;

import java.util.Objects;

import ladder.exception.NameLengthException;

public class Name {
    private static final String PERSON_NUMBER_MIN_EXCEPTION_COMMENT = "사람 이름이 최대길이인 %d를 넘었습니다.";
    private static final String PERSON_NUMBER_MAX_EXCEPTION_COMMENT = "사람 이름이 최소길이인 %d가 되지 않습니다. ";
    private static final String NAME_IS_NULL_EXCEPTION_COMMENT = "Name값이 널입니다.";
    private static final int PERSON_NAME_LENGTH_MAX = 5;
    private static final int PERSON_NAME_LENGTH_MIN = 1;

    final String name;

    private Name(String name) {
        validate(name);
        this.name = name;
    }

    public static Name from(String name) {
        return new Name(name);
    }

    private void validate(String name) {
        if (Objects.isNull(name)) {
            throw new NullPointerException(NAME_IS_NULL_EXCEPTION_COMMENT);
        }

        if (name.length() > PERSON_NAME_LENGTH_MAX) {
            throw new NameLengthException(String.format(PERSON_NUMBER_MIN_EXCEPTION_COMMENT, PERSON_NAME_LENGTH_MAX));
        }

        if (name.length() < PERSON_NAME_LENGTH_MIN) {
            throw new NameLengthException(String.format(PERSON_NUMBER_MAX_EXCEPTION_COMMENT, PERSON_NAME_LENGTH_MIN));
        }
    }

    public String name() {
        return name;
    }
}
