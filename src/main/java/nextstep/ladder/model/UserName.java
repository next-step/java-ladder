package nextstep.ladder.model;

import java.util.Objects;

public final class UserName {
    private static final int MIN_NAME_SIZE = 1;
    private static final int MAX_NAME_SIZE = 5;

    private final String name;

    public UserName(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        if (Objects.isNull(name)) {
            throw new IllegalArgumentException("전달된 사용자 이름이 null 입니다.");
        }
        int nameSize = name.length();
        if (nameSize < MIN_NAME_SIZE || nameSize > MAX_NAME_SIZE) {
            throw new IllegalArgumentException(String.format("전달된 사용자 이름은 %d <= x <= %d 이어야 합니다.", MIN_NAME_SIZE, MAX_NAME_SIZE));
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserName userName = (UserName) o;
        return Objects.equals(name, userName.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
