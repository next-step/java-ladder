package ladder.domain;

import java.util.Objects;

public class Player {
    private final PlayerName playerName;
    private final Position position;

    public Player(PlayerName playerName, Position position) {
        this.playerName = playerName;
        this.position = position;
    }

    public Player(String name) {
        this(new PlayerName(name), new Position());
    }

    public PlayerName name() {
        return playerName;
    }

    public Position position() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(playerName, player.playerName) && Objects.equals(position, player.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerName, position);
    }
}