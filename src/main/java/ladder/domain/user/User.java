package ladder.domain.user;

import java.util.Objects;

public class User {
    private final Name name;

    public User(final Name name) {
        Objects.requireNonNull(name, "User 객체를 생성할 수 없습니다.");
        this.name = name;
    }
}
