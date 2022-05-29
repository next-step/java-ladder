package nextstep.ladder.domain;

import java.util.Objects;

import nextstep.ladder.exception.InvalidPlayerNameException;

public class PlayerName {
    private static final int MAX_NAME_LENGTH = 5;
    private final String name;

    public PlayerName(final String name) {
        validate(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void validate(final String name) {
        if (Objects.isNull(name) || name.isEmpty()) {
            throw new InvalidPlayerNameException("이름은 비어있을 수 없습니다.");
        }

        if (name.length() > MAX_NAME_LENGTH) {
            throw new InvalidPlayerNameException("이름은 최대 5글자를 넘을 수 없습니다.");
        }
    }
}
