package ladder.domain.player;

import ladder.domain.player.Player;

import java.util.ArrayList;
import java.util.List;

public class Players {

    List<Player> playerList = new ArrayList<>();

    public Players(String playerNames) {
        String[] names = playerNames.split(",");

        for (String name : names) {
            playerList.add(new Player(name));
        }
    }

    public List<Player> getPlayers() {
        return playerList;
    }

    public int getPlayerNum() { return playerList.size(); }
}
