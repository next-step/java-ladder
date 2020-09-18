package step2.domain;

import java.util.Objects;

public class User {

    private final String name;

    private User(String name) {
        this.name = name;
    }

    public static User of(String name) {
        if (Objects.isNull(name)) {
            throw new IllegalArgumentException("사다리 게임 참여자 이름은 필수값 입니다.");
        }

        if (5 < name.length()) {
            throw new IllegalArgumentException("사다리 게임 참여자 이름은 최대 5글자까지 부여할 수 있습니다.");
        }

        return new User(name);
    }

    public String getName() {
        return name;
    }
}
