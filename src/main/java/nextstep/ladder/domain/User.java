package nextstep.ladder.domain;

import nextstep.ladder.util.StringUtils;

import java.util.Objects;

public class User {
    private static final int MAX_NAME_LENGTH = 5;

    private final String name;

    public User(final String name) {
        validateName(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void validateName(String name) {
        if (StringUtils.isBlank(name)) {
            throw new IllegalArgumentException("null or 빈 값으로 생성할 수 없습니다.");
        }
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 최대 5자까지 부여할 수 있습니다.");
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
        return Objects.hashCode(name);
    }

    @Override
    public String toString() {
        return name + " : ";
    }
}
