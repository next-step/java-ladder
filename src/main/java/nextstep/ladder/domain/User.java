package nextstep.ladder.domain;

import java.util.Objects;

public class User {
    private static final String LENGTH_ERROR_MESSAGE = "이름은 5글자를 초과할 수 없습니다. name: ";
    private static final String EMPTY_NAME_ERROR_MESSAGE = "이름은 공백일 수 없습니다.";
    private static final int MAX_LENGTH = 5;
    private static final String BLANK_REPLACEMENT = "";
    private static final String SPACE_REGEX = "\\s";
    private static final String BLANK_STRiNG = "";

    private final String name;

    public User(String name) {
        validateLength(eraseSpace(name));
        this.name = eraseSpace(name);
    }

    private void validateLength(String name) {
        if (name.equals(BLANK_STRiNG)) {
            throw new IllegalArgumentException(EMPTY_NAME_ERROR_MESSAGE);
        }
        if (name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(LENGTH_ERROR_MESSAGE + this);
        }
    }


    private String eraseSpace(String name) {
        return name.replaceAll(SPACE_REGEX, BLANK_REPLACEMENT);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return this.name;
    }
}
