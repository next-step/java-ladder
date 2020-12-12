package ladder.domain;


import ladder.ladderexceptions.InvalidUserNameException;

import java.util.Objects;

import static ladder.domain.LadderConstant.SEARCH_ALL_REQUEST;

public class User {
    private static final int MAXIMUM_NAME_LENGTH = 5;

    private final String name;

    public User(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (name.isEmpty() || name.length() > MAXIMUM_NAME_LENGTH || name.equals(SEARCH_ALL_REQUEST)) {
            throw new InvalidUserNameException();
        }
    }

    public String getName() {
        return this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(getName(), user.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}
