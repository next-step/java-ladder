package ladder.domain;

import ladder.exception.OutOfLengthException;

public class Player {
    private static final int MAX_NAME_LENGTH = 5;

    private final String name;

    public Player(String name) {
        validateNameLength(name);
        this.name = name;
    }

    private void validateNameLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new OutOfLengthException("플레이어 이름의 길이는 5자를 초과할 수 없습니다.");
        }
    }
}
