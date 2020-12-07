package nextstep.ladder.domain;

import java.util.Objects;

public class User {
    private static final int LENGTH_MINIMUM = 1;
    private static final int LENGTH_MAXIMUM = 5;
    private static final String LENGTH_MINIMUM_MENTION = "이름은 %d글자 이상이어야 합니다.";
    private static final String LENGTH_MAXIMUM_MENTION = "이름은 %d글자를 초과할 수 없습니다.";

    private String name;

    private User(String name) {
        checkValidate(name);
        this.name = name;
    }

    public static User of(String name) {
        return new User(name);
    }

    private void checkValidate(String name) {
        checkEmptyName(name);
        checkNameLength(name);
    }

    private void checkNameLength(String name) {
        if(name.length() > LENGTH_MAXIMUM) {
            throw new IllegalArgumentException(String.format(LENGTH_MAXIMUM_MENTION, LENGTH_MAXIMUM));
        }
    }

    private void checkEmptyName(String name) {
        if(name == null || name.trim().length() < LENGTH_MINIMUM) {
            throw new IllegalArgumentException(String.format(LENGTH_MINIMUM_MENTION, LENGTH_MINIMUM));
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
