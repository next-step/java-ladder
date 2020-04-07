package ladder.domain;

import java.util.Objects;

public class Player {
    private final PlayerName name;
    private final Position position;

    public Player(final String name, final int startPosition) {
        this.name = new PlayerName(name);
        this.position = new Position(startPosition);
    }

    public PlayerName name() {
        return name;
    }

    public boolean same(PlayerName playerName) {
        return name.equals(playerName);
    }

    public Position startPosition() {
        return position;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Player player = (Player) o;
        return Objects.equals(name, player.name) &&
                Objects.equals(position, player.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
