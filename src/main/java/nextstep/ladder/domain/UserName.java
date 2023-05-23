package nextstep.ladder.domain;

import java.util.Objects;

public class UserName {
    private static final int MAX_NAME_LENGTH = 5;

    private String name;

    private UserName(String name) {
        this.name = name;
    }

    public static UserName of(String name) {
        isInValidName(name);
        return new UserName(name);
    }

    private static void isInValidName(String name) {
        if (Objects.isNull(name) || name.isEmpty()) {
            throw new IllegalArgumentException("이름을 확인 하세요.");
        }
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("이름이 5자를 초과했습니다.");
        }
    }

    public String name() {
        return name;
    }

}
