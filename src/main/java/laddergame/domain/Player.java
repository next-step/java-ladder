package laddergame.domain;

import laddergame.exception.ErrorCode;
import laddergame.exception.LadderGameException;

import java.util.Objects;

public class Player {
    private static final int MAXIMUM_NAME_LENGTH = 5;

    private final String name;

    public Player(String name) {
        validateNullOrEmpty(name);
        validateLengthOverMaximum(name);
        this.name = name;
    }

    private void validateLengthOverMaximum(String name) {
        if (name.length() > MAXIMUM_NAME_LENGTH) {
            throw new LadderGameException(ErrorCode.NAME_OVER_MAXMUM_LENGTH);
        }
    }

    private void validateNullOrEmpty(String name) {
        if (Objects.isNull(name) || name.isEmpty()) {
            throw new LadderGameException(ErrorCode.NULL_OR_EMPTY_INPUT);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
