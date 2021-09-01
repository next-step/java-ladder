package ladder.domain;

import ladder.exception.UserNameLengthException;

import java.util.Objects;

public class User {
    private final String name;
    private static final int MAX_NAME_LENGTH = 5;
    private static final int MIN_NAME_LENGTH = 1;

    public User(String name) {
        validateName(name);
        this.name = name;
    }

    public static User valueOf(String name) {
        return new User(name);
    }

    private void validateName(String name) {
        if (name.length() > MAX_NAME_LENGTH || name.length() < MIN_NAME_LENGTH) {
            throw new UserNameLengthException();
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        User user = (User) o;
        return Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
