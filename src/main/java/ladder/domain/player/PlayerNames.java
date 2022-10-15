package ladder.domain.player;

import java.util.List;
import java.util.Objects;

public class PlayerNames {
    private final List<PlayerName> playerNames;

    public PlayerNames(List<PlayerName> playerNames) {
        this.playerNames = playerNames;
    }

    public List<PlayerName> names() {
        return playerNames;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PlayerNames)) return false;

        PlayerNames that = (PlayerNames) o;

        return Objects.equals(playerNames, that.playerNames);
    }

    @Override
    public int hashCode() {
        return playerNames != null ? playerNames.hashCode() : 0;
    }
}
