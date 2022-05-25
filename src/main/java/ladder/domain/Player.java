package ladder.domain;

import java.util.Objects;

public class Player {
    public static final int MAX_PLAYER_NAME = 5;
    private final String name;

    public Player(String name) {
        if (name.length() > MAX_PLAYER_NAME) {
            throw new IllegalArgumentException("name should be less than 5, but: " + name.length());
        }
        this.name = name;
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

    public String name() {
        return this.name;
    }
}
