package nextstep.ladder.domain;

import java.util.Objects;

public class User {
    private final String name;

    public User(String name) {
        checkNameNotOver5(name);
        this.name = name;
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return name.equals(user.name);
    }

    @Override public int hashCode() {
        return Objects.hash(name);
    }

    @Override public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }

    private void checkNameNotOver5(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름의 길이는 5를 넘지 않아야 합니다.");
        }
    }
}
