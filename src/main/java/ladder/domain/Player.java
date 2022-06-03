package ladder.domain;

import ladder.exception.PlayerNameLengthExceedException;

import java.util.Objects;

public class Player {
    public static final int MAX_PLAYER_NAME = 5;
    private final String name;
    public Player(String name) {
        if (name.length() > MAX_PLAYER_NAME) {
            throw new PlayerNameLengthExceedException(name.length());
        }

        this.name = name;
    }

    public String name() {
        return this.name;
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

    public boolean nameEquals(String playerName) {
        return this.name.equals(playerName);
    }
}
