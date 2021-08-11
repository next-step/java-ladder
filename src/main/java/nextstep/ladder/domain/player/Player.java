package nextstep.ladder.domain.player;

import nextstep.ladder.domain.exception.PlayerNameLengthLimitException;

import java.util.Objects;

public class Player {
    public static final int NAME_LENGTH_LIMIT = 5;

    private final String name;
    private final Position position;

    private Player(final String name, final Position position) {
        this.name = name;
        this.position = position;
    }

    public static Player of(final String name, final int position) {
        verifyNameLength(Objects.requireNonNull(name));
        return new Player(name, Position.from(position));
    }

    private static void verifyNameLength(final String name) {
        if (name.length() > NAME_LENGTH_LIMIT) {
            throw new PlayerNameLengthLimitException(String.format("참가자 이름의 길이는 %s글자를 넘을 수 없습니다.", NAME_LENGTH_LIMIT));
        }
    }

    public String name() {
        return name;
    }

    public Position position() {
        return position;
    }
}
