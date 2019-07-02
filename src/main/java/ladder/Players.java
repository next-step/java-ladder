package ladder;

import java.util.ArrayList;
import java.util.List;

public class Players {

    private List<Player> players;

    public Players(String playersNames) {
        this.players = addPlayers(playersNames);
    }

    private List<Player> addPlayers(String playersNames) {
        List<Player> players = new ArrayList<>();
        for (String playerName : playersNames.split(",")) {
            players.add(new Player(playerName));
        }
        return players;
    }

    public int size() {
        return players.size();
    }

    public List<String> getPlayerList() {
        List<String> playerList = new ArrayList<>();
        for (Player player : players) {
            playerList.add(player.getPlayerName());
        }
        return playerList;
    }
}
