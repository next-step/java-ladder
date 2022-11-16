package nextstep.ladder.domain;

import nextstep.exception.CustomException;
import nextstep.ladder.exception.UserErrorCode;

import java.util.Objects;

public class User {

    public static final int NAME_MAXIMUM_VALUE = 5;
    private final String name;

    public User(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (name.length() > NAME_MAXIMUM_VALUE) {
            throw new CustomException(UserErrorCode.USER_NAME_LENGTH_BAD_REQUEST);
        }
    }

    public String getName() {
        return name;
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
}
