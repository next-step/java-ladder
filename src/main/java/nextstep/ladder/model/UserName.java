package nextstep.ladder.model;

import java.util.Objects;

public final class UserName {
    private static final int MAX_NAME_SIZE = 5;

    private final String name;

    public UserName(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        if (Objects.isNull(name)) {
            throw new IllegalArgumentException("전달된 이름이 null입니다.");
        }
        if (name.length() > MAX_NAME_SIZE) {
            throw new IllegalArgumentException(String.format("전달된 이름이 %d을 초과했습니다.", MAX_NAME_SIZE));
        }
    }

    public String getName() {
        return name;
    }
}
