package ladder.domain;

import java.util.Objects;

public class User {

    public static final int MAXIMUM_NAME_SIZE = 5;

    private final String name;

    private User(String name) {
        validate(name);
        this.name = name;
    }

    public static User createWithName(String name) {
        return new User(name);
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

    private void validate(String name) {
        if (isNullOrEmpty(name)) {
            throw new IllegalArgumentException("이름이 비어있을 수 없습니다.");
        }

        if (name.length() > MAXIMUM_NAME_SIZE) {
            throw new IllegalArgumentException("이름이 너무 깁니다.");
        }
    }

    private boolean isNullOrEmpty(String name) {
        return name == null || name.isEmpty();
    }
}
