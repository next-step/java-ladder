package ladder.domain;

import java.util.*;
import java.util.stream.Collectors;

public class Players {
    private final List<Player> players;

    private Players(List<Player> players) {
        if (players.isEmpty()) {
            throw new IllegalArgumentException("참가자는 1명 이상있어야 한다");
        }
        this.players = Collections.unmodifiableList(players);
    }

    public static Players valueOf(String[] playerNames) {
        List<Player> players = new ArrayList<>();
        for (int i = 0 ; i <playerNames.length ; i++) {
            players.add(new Player(playerNames[i], i));
        }
        return new Players(players);
    }

    public List<Player> getPlayers() {
        return players;
    }

    public List<String> getPlayerNames() {
        return players.stream()
                .map(Player::getName)
                .collect(Collectors.toList());
    }

    public Player findByName(String name) {
        return players.stream()
                .filter(player -> player.matchByName(name))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(name + " 의 player 는 없습니다."));
    }
}
