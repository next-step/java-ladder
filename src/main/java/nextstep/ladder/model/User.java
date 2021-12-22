package nextstep.ladder.model;

import java.util.Objects;

public final class User {

    private final UserName name;

    public User(UserName name) {
        validate(name);
        this.name = name;
    }

    private void validate(UserName name) {
        if (Objects.isNull(name)) {
            throw new IllegalArgumentException("전달된 이름이 null입니다.");
        }
    }

    public String getName() {
        return name.getName();
    }
}
