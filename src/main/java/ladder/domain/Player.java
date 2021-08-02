package ladder.domain;

import ladder.exception.OutOfLengthException;

import java.util.Objects;

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

    @Override
    public boolean equals(Object compareValue) {
        if (this == compareValue) return true;
        if (compareValue == null || getClass() != compareValue.getClass()) return false;
        Player player = (Player) compareValue;
        return Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public String toString() {
        return name;
    }
}
