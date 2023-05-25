package nextstep.ladder.domain.user;

import java.util.Objects;

public class User {

    private static final int MAX_USER_NAME = 5;
    private final String name;

    public User(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        if (name.length() > MAX_USER_NAME) {
            throw new IllegalArgumentException("사람의 이름은 최대 5자까지 가능합니다.");
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

    @Override
    public String toString() {
        return String.format("%-" + MAX_USER_NAME + "s ", this.name);
    }
}
