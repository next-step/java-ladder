package ladder.domain.model;

import java.util.List;

public class PlayerNames {
    List<PlayerName> playerNames;

    public PlayerNames(List<PlayerName> playerNames) {
        this.playerNames = playerNames;
    }

    public List<PlayerName> getPlayerNames() {
        return playerNames;
    }

    public int getCount() {
        return playerNames.size();
    }
}
