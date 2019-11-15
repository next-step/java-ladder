package ladder.domain;

import java.util.ArrayList;
import java.util.List;

class Players {
    private static final String DELIMITER = ",";
    private final List<Player> players;

    Players(String players) {
        this.players = addPlayers(players);
    }

    private List<Player> addPlayers(final String playerNames) {
        final String[] splitPlayerNames = playerNames.split(DELIMITER);
        final List<Player> players = new ArrayList<>();

        for (String playerName : splitPlayerNames) {
            players.add(new Player(playerName));
        }

        return players;
    }

    int count() {
        return this.players.size();
    }

    List<String> getNames() {
        final List<String> playerNames = new ArrayList<>();

        for (Player player : players) {
            playerNames.add(player.getName());
        }

        return playerNames;
    }
}
