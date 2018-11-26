package net.chandol.domain.player;

import java.util.Objects;

import static net.chandol.support.FluentUtil.validate;

public class Player {
    private String name;

    public Player(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        validate(Objects.isNull(name), () -> new IllegalArgumentException("이름은 null이 될 수 없습니다."));
        validate(name.length() >= 5, () -> new IllegalArgumentException("이름의 길이는 5 이하여야 합니다."));
    }

    public String getName() {
        return name;
    }
}
