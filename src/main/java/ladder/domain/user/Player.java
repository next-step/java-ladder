package ladder.domain.user;

import java.util.Objects;

public class Player {

    private final PlayerName playerName;

    public Player(String name) {
        this.playerName = new PlayerName(name);
    }

    public boolean isEqualsName(String targetName) {
        return this.playerName.isSameName(targetName);
    }

    public PlayerName getPlayerName() {
        return this.playerName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o){
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Player player = (Player) o;
        return Objects.equals(playerName, player.playerName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerName);
    }

    @Override
    public String toString() {
        return playerName.getName();
    }

}
