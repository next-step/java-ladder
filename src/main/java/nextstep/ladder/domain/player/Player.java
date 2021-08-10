package nextstep.ladder.domain.player;

import nextstep.ladder.domain.exception.PlayerNameLengthLimitException;

import java.util.Objects;

public class Player {
    public static final int NAME_LENGTH_LIMIT = 5;

    private final String name;

    private Player(final String name) {
        this.name = name;
    }

    public static Player from(final String name) {
        verifyNameLength(Objects.requireNonNull(name));
        return new Player(name);
    }

    private static void verifyNameLength(final String name) {
        if (name.length() > NAME_LENGTH_LIMIT) {
            throw new PlayerNameLengthLimitException(String.format("참가자 이름의 길이는 %s를 넘을 수 없습니다.", NAME_LENGTH_LIMIT));
        }
    }

    public String getName() {
        return name;
    }
}
