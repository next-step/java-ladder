package nextstep.ladder;

import java.util.Objects;

public class Player {

    private final PlayerName playerName;
    private final int position;

    public Player(PlayerName playerName, int position) {
        this.playerName = playerName;
        this.position = position;
    }

    public PlayerName getPlayerName() {
        return playerName;
    }

    public int getPosition() {
        return position;
    }

    public boolean findPlayerName(String playerName) {
        return this.playerName.getPlayerName().equals(playerName);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(playerName, player.playerName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerName);
    }
}
