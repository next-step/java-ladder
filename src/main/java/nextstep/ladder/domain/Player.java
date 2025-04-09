package nextstep.ladder.domain;

import java.util.Objects;

public class Player {
    private static final int MAX_NAME_LENGTH = 5;

    private final String value;

    public Player(String value) {
        if (value.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("invalid player name length");
        }
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Player player = (Player) o;
        return Objects.equals(value, player.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}
