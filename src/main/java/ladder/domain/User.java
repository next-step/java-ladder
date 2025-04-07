package ladder.domain;

import java.util.Objects;

import ladder.exception.UserNameInvalidException;

public class User {
    private final String name;

    public User(String name) {
        validation(name);
        this.name = name;
    }

    private void validation(String name) {
        if (name == null || name.isEmpty()) {
            throw new UserNameInvalidException();
        }

        if (name.length() > 5) {
            throw new UserNameInvalidException();
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
        return Objects.hashCode(name);
    }
}
