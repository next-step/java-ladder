package nextstep.ladder.domain;

import java.util.Objects;

public class UserName {
    private static int MAX_NAME_LENGTH = 5;

    private String name;

    private UserName(String name) {
        this.name = name;
    }

    public static UserName of(String name) {
        if (isInValidName(name)) {
            throw new IllegalArgumentException("이름의 길이가 5자를 초과했습니다.");
        }
        return new UserName(name);
    }

    private static boolean isInValidName(String name) {
        return Objects.isNull(name) || name.isEmpty() || name.length() > MAX_NAME_LENGTH;
    }

    public String name() {
        return name;
    }

}
