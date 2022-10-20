package nextstep.laddar;

import java.util.Optional;

public class User {
    private static final int NAME_MAX_LENGTH = 5;

    private final String name;

    public User(String name) {
        this.name = Optional.ofNullable(name)
                .filter(username -> NAME_MAX_LENGTH >= username.length())
                .orElseThrow(() -> new IllegalArgumentException("이름은 5자를 넘을 수 없습니다."));
    }

    public String getName() {
        return name;
    }

    public static int getMaxNameLength() {
        return NAME_MAX_LENGTH;
    }
}
