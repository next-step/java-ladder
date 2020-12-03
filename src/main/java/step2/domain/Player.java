package step2.domain;

import java.util.Objects;

public class Player {

    private final PlayerGameName playerGameName;
    private final PlayerGamePosition playerGamePosition;

    public Player(final PlayerGameName playerGameName, final PlayerGamePosition playerGamePosition) {
        this.playerGameName = playerGameName;
        this.playerGamePosition = playerGamePosition;
    }

    public static Player of(final String name, final int position) {
        return new Player(PlayerGameName.of(name),  PlayerGamePosition.of(position));
    }

    public String getPlayerGameName() {
        return playerGameName.getName();
    }

    public int getPlayerGamePosition() {
        return playerGamePosition.getPosition();
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(playerGameName, player.playerGameName) &&
                Objects.equals(playerGamePosition, player.playerGamePosition);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerGameName, playerGamePosition);
    }
}
