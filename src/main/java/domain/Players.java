package domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Players {
    private final List<Player> players;

    private Players(String[] playerNames) {
        this.players = Arrays.stream(playerNames)
                .map(Player::of)
                .collect(Collectors.toList());
    }

    public static Players of(String[] playerNames) {
        return new Players(playerNames);
    }

    public int countOfPlayers() {
        return players.size();
    }

    public String[] getPlayerNames() {
        return players.stream()
                .map(Player::getPlayerName)
                .toArray(size -> new String[size]);
    }

    public String getPlayerName(int index) {
        return players.get(index).getPlayerName();
    }
}
