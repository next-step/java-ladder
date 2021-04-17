package nextstep.ladder.entity.user;

import nextstep.ladder.common.Constants;

import java.util.Objects;

public class User {
    private final String name;
    private final int startPosition;

    public User(String name, int startPosition) {
        nameValid(name);
        this.name = name;
        this.startPosition = startPosition;
    }

    public String name() {
        return name;
    }

    public int startPosition() {
        return startPosition;
    }

    private void nameValid(String name) {
        if (name.length() > Constants.MAX_NAME_SIZE) {
            throw new IllegalArgumentException(Constants.NAME_LENGTH_OVER_MESSAGE);
        }
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
