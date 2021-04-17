package step4.domain;

import java.util.Objects;

public class Player {
    private final PlayerName playerName;
    private final Position position;

    public Player(int number, String name) {
        position = Position.valueOf(number);
        playerName = new PlayerName(name);
    }

    public boolean isNameEqual(PlayerName playerName) {
        return this.playerName.equals(playerName);
    }

    public Position playerPosition() {
        return this.position;
    }

    public PlayerName playerName() {
        return this.playerName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Player player = (Player)o;
        return Objects.equals(playerName, player.playerName) && Objects.equals(position,
            player.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerName, position);
    }
}
