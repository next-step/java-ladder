package nextstep.ladder.domain;

import java.util.Objects;

public class User {
    public static final int LENGTH_LIMIT = 5;
    public static final String LENGTH_LIMIT_MENTION = "이름은 %d글자를 초과할 수 없습니다.";
    private String name;

    public User(String name) {
        checkNameLength(name);
        this.name = name;
    }

    private void checkNameLength(String name) {
        if(name.length() > LENGTH_LIMIT) {
            throw new IllegalArgumentException(String.format(LENGTH_LIMIT_MENTION, LENGTH_LIMIT));
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
