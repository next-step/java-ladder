package ladder.domain;

import java.util.List;

public class PlayerNames {
    private final List<PlayerName> playerNames;

    public PlayerNames(List<PlayerName> playerNames) {
        this.playerNames = playerNames;
    }

    public List<PlayerName> names() {
        return playerNames;
    }
}
