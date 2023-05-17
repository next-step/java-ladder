package ladder.domain.player;

import java.util.List;

public class Players {
    private final List<Player> playerList;

    public Players(List<Player> playerList) {
        this.playerList = playerList;
    }

    public List<Player> getPlayerList() {
        return List.copyOf(playerList);
    }

    public int getPlayerNumber() {
        return playerList.size();
    }
}
