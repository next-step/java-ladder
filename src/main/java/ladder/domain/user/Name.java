package ladder.domain.user;

import static ladder.util.StringUtil.isBlank;

import java.util.Objects;

public class Name {

    private static final int MAXIMUM_NAME_LENGTH = 5;

    private static final String INVALID_EMPTY_NAME_ERROR_MESSAGE = "사람의 이름은 반드시 제공되어야 한다.";
    private static final String INVALID_MAXIMUM_NAME_LENGTH_ERROR_MESSAGE = "사람의 이름은 최대 5글자까지만 입력가능하다.";

    private final String name;

    public Name(String name) {
        checkNameNotBlank(name);
        checkNameLength(name);

        this.name = name;
    }

    private static void checkNameNotBlank(String name) {
        if (isBlank(name)) {
            throw new IllegalArgumentException(INVALID_EMPTY_NAME_ERROR_MESSAGE);
        }
    }

    private static void checkNameLength(String name) {
        if (name.length() > MAXIMUM_NAME_LENGTH) {
            throw new IllegalArgumentException(INVALID_MAXIMUM_NAME_LENGTH_ERROR_MESSAGE);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Name name1 = (Name) o;
        return Objects.equals(name, name1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

}
