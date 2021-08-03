package nextstep.ladder.domain.player;

import java.util.Objects;

public class Player {
    public static final int MAXIMUM_LENGTH_OF_NAME = 5;

    private final String name;

    private Player(String name) {
        validate(name);

        this.name = name;
    }

    private void validate(String name) {
        if (isEmpty(name)) {
            throw new IllegalArgumentException("이름은 null이거나 비어있을수 없습니다.");
        }

        if (name.length() > MAXIMUM_LENGTH_OF_NAME) {
            throw new IllegalArgumentException("이름은 최대 " + MAXIMUM_LENGTH_OF_NAME + "자 입니다.");
        }
    }

    public static Player of(String name) {
        return new Player(name);
    }

    public String getName() {
        return name;
    }

    private boolean isEmpty(String stringValue) {
        return Objects.isNull(stringValue) || stringValue.isEmpty();
    }
}
